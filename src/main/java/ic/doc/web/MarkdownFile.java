package ic.doc.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MarkdownFile implements Page {


  private final String query;
  private final String answer;
//  private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
  private static final int MAX_OUT = 4096; /* Arbitrary number */

  public MarkdownFile(String query, String answer) {
    this.query = query;
    this.answer = answer;
  }

  @Override
  public void writeTo(HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    resp.setHeader("Content-disposition", "attachment; filename=result.md");

//    PrintWriter writer = resp.getWriter();
//    displayMd(writer);

    StringBuffer sb = generateMdFile();
    InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
    ServletOutputStream out = resp.getOutputStream();

    byte[] outputByte = new byte[MAX_OUT];
    while(in.read(outputByte, 0, MAX_OUT) != -1)
    {
      out.write(outputByte, 0, MAX_OUT);
    }
    in.close();
    out.flush();
    out.close();
  }

  private void displayMd(PrintWriter writer) {
    String fileName = "/result.md";

    try (InputStream fis = new FileInputStream(fileName);
         InputStreamReader isr = new InputStreamReader(fis,
             StandardCharsets.UTF_8);
         BufferedReader br = new BufferedReader(isr)) {

      br.lines().forEach(line -> writer.println(line));
    } catch (Exception e) {
      System.out.println("Exception" + e.toString() + " occurred");
    }
  }

  private StringBuffer generateMdFile() {

    StringBuffer writer = new StringBuffer();

    if (answer == null || answer.isEmpty()) {
      writer.append("# Sorry\n");
      writer.append("### ");
      writer.append("Sorry, we didn't understand *" + query + "*.\n");
    } else {
      writer.append("# " + query + "\n");
      writer.append(answer + "\n");
    }

    return writer;
  }
}
