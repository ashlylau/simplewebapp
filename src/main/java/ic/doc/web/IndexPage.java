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
//        writer.println("<link rel=\"stylesheet\" href=\"https://unpkg.com/purecss@1.0.0/build/pure-min.css\" integrity=\"sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w\" crossorigin=\"anonymous\">");
        writer.println("<body>");
        writer.println("<style>" +
                "body { }");

        writer.println("</style>");
        // Content
        writer.println(

                "<h1><center><font size=\"10\">Group 5 WebApp</font></center></h1>" +
                        "<p><center><font face=\"Bedrock\" size=\"6\">Enter your query in the box below:</font></center> " +
                        "<form>" +
                        "<br>" +
                        "<center><input type=\"text\" name=\"q\" placeholder=\"Search..\"/></center>" +
                        "<br><br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"html\" /> <font size=\"4\">View as HTML</font></center>" +
                        "<br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"markdown\" /> <font size=\"4\">Download as Markdown</font></center>" +
                        "<br>" +
                        "<center><input type=\"radio\" name=\"type\" value = \"pdf\" /> <font size=\"4\">Download as PDF</font></center>" +
                        "<center><br><br><br><input type=\"submit\"></center>" +
                        "</form>" +
                        "</p>");
        
        // Footer

        writer.println("</body>");
        writer.println("</html>");
    }
    
}
