package ic.doc.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ic.doc.WebServer.TMP_DIR;

public class MarkdownPage implements Page {
  
  @Override
  public void writeTo(HttpServletResponse resp) throws IOException {
    resp.setContentType("text/markdown");
    
    Path path = Paths.get(TMP_DIR + "/result.md");
    Files.copy(path, resp.getOutputStream());
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
}
