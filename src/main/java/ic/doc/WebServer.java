package ic.doc;

import ic.doc.web.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");

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

            if (query == null) {
                new IndexPage().writeTo(resp);
            } else {
                if (type == null || type.equals("html")) {
                    new HTMLResultPage(query, new QueryProcessor().process(query)).writeTo(resp);
                } else if (type.equals("markdown")) {
                    MarkdownFileGenerator generator = new MarkdownFileGenerator(query, new QueryProcessor().process(query));
                    generator.generate();
                    new MarkdownPage().writeTo(resp);
                } else if (type.equals("pdf")) {
                    MarkdownFileGenerator generator = new MarkdownFileGenerator(query, new QueryProcessor().process(query));
                    generator.generate();
                    new PdfPage().writeTo(resp);
                } else if (type.equals("latex")) {
                    MarkdownFileGenerator generator = new MarkdownFileGenerator(query, new QueryProcessor().process(query));
                    generator.generate();
                    new LatexPage().writeTo(resp);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new WebServer();
    }
}

