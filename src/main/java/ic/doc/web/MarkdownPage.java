package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    Files.delete(path);
  }
}
