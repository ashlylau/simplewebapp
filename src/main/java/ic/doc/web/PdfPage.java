package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ic.doc.WebServer.TMP_DIR;

public class PdfPage implements Page {
  
  @Override
  public void writeTo(HttpServletResponse resp) throws IOException {
    resp.setContentType("application/pdf");
    
    getPdf();
    Path path = Paths.get(TMP_DIR + "/result.pdf");
    Files.copy(path, resp.getOutputStream());
    Files.delete(path);
  }

  private void getPdf() {
    ProcessBuilder pb = new ProcessBuilder("pandoc", TMP_DIR + "/result.md", "-s", "-o", TMP_DIR + "/result.pdf");
    final Process p;
    
    try {
      p = pb.start();
      p.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
