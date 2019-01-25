package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexPage implements Page {

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Header
        writer.println("<html>");
        writer.println("<head><title>Welcome</title></head>");
        writer.println("<link rel=\"stylesheet\" href=\"https://www.google.com/css/maia.css\">");
        writer.println("<body>");
        writer.println("<style>" +
                "body { background-color: #5dade2; }");

        writer.println("</style>");
        // Content
        writer.println(

                "<h1><center><font size=\"10\">Welcome to our WebApp!!</font></center></h1>" +
                        "<p><i><center><font face=\"Bedrock\" size=\"6\">Enter your query in the box below:</font></center></i> " +
                        "<form>" +
                        "<br>" +
                        "<center><input type=\"text\" name=\"q\" placeholder=\"Search..\"/></center>" +
                        "<br><br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"html\" /> <b><font size=\"4\">View as HTML</font></center></b>" +
                        "<br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"markdown\" /> <b><font size=\"4\">Download as Markdown</font></center></b>" +
                        "<br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"pdf\" /> <font size=\"4\">Download as PDF\n</font></center" +
                        "<br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"latex\" /> <font size=\"4\">Download as LaTeX</font></center>" +
                        "<br><br><input type=\"submit\">" +
                        "</form>" +
                        "</p>");


        // Footer

        writer.println("</body>");
        writer.println("</html>");
    }
    
}
