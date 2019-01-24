package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLResultPage implements Page {

    private final String query;
    private final String answer;

    public HTMLResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Header
        writer.println("<html>");
        writer.println("<head><title>" + query + "</title></head>");
        writer.println("<body>");

        // Content
        if (answer == null || answer.isEmpty()) {
            writer.println("<h1><center>Sorry</center></h1>");
            writer.print("<p><center>Sorry, we didn't understand <em>" + query + "</em>  please try again!</center></p>");
        } else {
            writer.println("<h1><center>" + query + "</center></h1>");
            writer.println("<p><center>" + answer.replace("\n", "<br>") + "</center></p>");
        }

        writer.println("<p><center><a href=\"/\">Back to Search Page</a></center></p>");

//        JRadioButton option1 = new JRadioButton("Download as HTML");
//        option1.setActionCommand(option1.getText());
//        JRadioButton option2 = new JRadioButton("Download as Markdown");
//
//        writer.println("<form method=\"POST\">");
//        writer.println("<input type=\"radio\" name=\"type\" value = \"markdown\" /> Download as Markdown");
//        writer.println("<input type=\"radio\" name=\"type\" value = \"pdf\" /> Download as PDF");
//        writer.println("<input type=\"submit\" name=\"download\" value=\"Download\"");
//        writer.println("</form>");

//        writer.println("<input type=\"radio\" name=\"d\"> Download as HTML");
//        writer.println("<input type=\"radio\" name=\"d\"> Download as Markdown");




//        new JRadioButtonOption().setVisible(true);

        // Footer
        writer.println("</body>");
        writer.println("</html>");
    }


}
