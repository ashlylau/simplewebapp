package ic.doc;

import ic.doc.web.HTMLResultPage;
import ic.doc.web.IndexPage;
import ic.doc.web.MarkdownFile;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {

    public WebServer() throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new Website()), "/*");
        server.setHandler(handler);

        server.start();
    }

    static class Website extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String query = req.getParameter("q");
            String type = req.getParameter("type");

            if (type != null) {
                System.out.println("TYPE IS NOT NULL!");
                if (type.equals("markdown")) {
                    new MarkdownFile(query, new QueryProcessor().process(query)).writeTo(resp);
                } else if (type.equals("pdf")) {
                    // TODO
                }
            } else {
                System.out.println("TYPE IS NULL!");
                if (query == null) {
                    new IndexPage().writeTo(resp);
                } else {
                    new HTMLResultPage(query, new QueryProcessor().process(query)).writeTo(resp);
                }
            }


        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("DO POST called");
            String type = req.getParameter("type");
            System.out.println(type);

            if (req.getParameter("download") != null) {
                System.out.println("im hereee");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new WebServer();
    }
}

