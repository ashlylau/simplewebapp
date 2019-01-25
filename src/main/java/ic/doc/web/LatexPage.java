package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ic.doc.WebServer.TMP_DIR;

public class LatexPage implements Page {
  @Override
  public void writeTo(HttpServletResponse resp) throws IOException {
    resp.setContentType("application/x-tex");

    createLatex();
    Path path = Paths.get(TMP_DIR + "/result.tex");
    Files.copy(path, resp.getOutputStream());
    Files.delete(path);
  }

  private void createLatex() {
    ProcessBuilder pb = new ProcessBuilder("pandoc", TMP_DIR + "/result.md", "-f", "markdown", "-t", "latex", "-s", "-o", TMP_DIR + "/result.tex");
    final Process p;

    try {
      p = pb.start();
      p.waitFor();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
