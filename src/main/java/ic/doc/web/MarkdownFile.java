package ic.doc.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MarkdownFile implements Page {


  private final String query;
  private final String answer;
  private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

  public MarkdownFile(String query, String answer) {
    this.query = query;
    this.answer = answer;
  }

  @Override
  public void writeTo(HttpServletResponse resp) throws IOException {
//    resp.setContentType("text/markdown; charset=UTF-8");

    resp.setContentType("application/octet-stream");
    resp.setHeader("Content-Disposition", "attachment:filename=result.md");

    File dir = new File(TMP_DIR);
    File tempFile = File.createTempFile("result", ".md", dir);
    FileWriter fileWriter = new FileWriter(tempFile, true);

    fileWriter.write("# ");
    fileWriter.write(query + "\n");
//
//    writer.print("# ");
//    writer.println(query);

    if (answer == null || answer.isEmpty()) {
      fileWriter.write("## Sorry\n");
      fileWriter.write("### ");
      fileWriter.write("Sorry, we didn't understand *" + query + "*.\n");
//      writer.println("## Sorry");
//      writer.print("### ");
//      writer.println("Sorry, we didn't understand *" + query + "*.");
    } else {
      fileWriter.write("### ");
      fileWriter.write(answer + "\n");
//      writer.print("### ");
//      writer.println(answer);
    }

    FileInputStream fileIn = new FileInputStream(tempFile);
    ServletOutputStream out = resp.getOutputStream();

    byte[] outputByte = new byte[4096];
    while(fileIn.read(outputByte, 0, 4096) != -1) {
      out.write(outputByte, 0, 4096);
    }
    fileIn.close();
    out.flush();
    out.close();

//    PrintWriter writer = resp.getWriter();



    tempFile.deleteOnExit();
  }
}
