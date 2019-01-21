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
    resp.setContentType("text/plain");
    resp.setHeader("Content-disposition", "attachment; filename=result.md");

    StringBuffer sb = generateMdFile();
    InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
    ServletOutputStream out = resp.getOutputStream();

    byte[] outputByte = new byte[4096];
//copy binary contect to output stream
    while(in.read(outputByte, 0, 4096) != -1)
    {
      out.write(outputByte, 0, 4096);
    }
    in.close();
    out.flush();
    out.close();



//    resp.setContentType("text/markdown; charset=UTF-8");



//    resp.setContentType("application/octet-stream");
//    resp.setHeader("Content-Disposition", "attachment:filename=result.md");
//
//    File dir = new File(TMP_DIR);
//    File tempFile = File.createTempFile("result", ".md", dir);
//    FileWriter fileWriter = new FileWriter(tempFile, true);
//    BufferedWriter bw = new BufferedWriter(fileWriter);
//    bw.write(generateMdFile().toString());
//    bw.close();
//
//    Files.copy()
//
//    fileWriter.write("# ");
//    fileWriter.write(query + "\n");
////
////    writer.print("# ");
////    writer.println(query);
//
//    if (answer == null || answer.isEmpty()) {
//      fileWriter.append("## Sorry\n");
//      fileWriter.append("### ");
//      fileWriter.append("Sorry, we didn't understand *" + query + "*.\n");
////      writer.println("## Sorry");
////      writer.print("### ");
////      writer.println("Sorry, we didn't understand *" + query + "*.");
//    } else {
//      fileWriter.append("### ");
//      fileWriter.append(answer + "\n");
////      writer.print("### ");
////      writer.println(answer);
//    }
//
//    fileWriter.close();
//
////    FileInputStream fileIn = new FileInputStream(tempFile);
//    ServletOutputStream out = resp.getOutputStream();
//
//    StringBuffer sb = generateMdFile();
//    InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
//
//    byte[] outputByte = new byte[4096];
//    while(in.read(outputByte, 0, 4096) != -1) {
//      out.write(outputByte, 0, 4096);
//    }
//    in.close();
//    out.flush();
//    out.close();
////    PrintWriter writer = resp.getWriter();
//
//
//
//    tempFile.deleteOnExit();
  }

  private StringBuffer generateMdFile() {

    StringBuffer writer = new StringBuffer();

    if (answer == null || answer.isEmpty()) {
      writer.append("## Sorry\n");
      writer.append("### ");
      writer.append("Sorry, we didn't understand *" + query + "*.\n");
//      writer.println("## Sorry");
//      writer.print("### ");
//      writer.println("Sorry, we didn't understand *" + query + "*.");
    } else {
      writer.append("### ");
      writer.append(answer + "\n");
//      writer.print("### ");
//      writer.println(answer);
    }

    return writer;

  }
}
