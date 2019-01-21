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
        writer.println("<body>");

        // Content
        writer.println(
                "<h1>Welcome!!</h1>" +
                        "<p>Enter your query in the box below: " +
                        "<form>" +
                        "<input type=\"text\" name=\"q\" />" +
                        "<br><br>" +
//                        "<input type=\"radio\" name=\"type\" value = \"html\" /> Download as HTML" +
//                        "<input type=\"radio\" name=\"type\" value = \"markdown\" /> Download as Markdown" +
//                        "<input type=\"radio\" name=\"type\" value = \"pdf\" /> Download as PDF" +
                        "<br><br><input type=\"submit\">" +
                        "</form>" +
                        "</p>");

        // Radio Buttons
//        writer.println("<input type=\"radio\" name=\"type\" value = \"html\" /> Download as HTML");
//        writer.println("<input type=\"radio\" name=\"type\" value = \"markdown\" /> Download as Markdown");
//        writer.println("<input type=\"radio\" name=\"type\" value = \"pdf\" /> Download as PDF");

        // Footer
        writer.println("</body>");
        writer.println("</html>");
    }
    
}
