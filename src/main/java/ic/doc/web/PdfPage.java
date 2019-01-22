package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
  }

  private void getPdf() {
    try {
      ProcessBuilder pb = new
              ProcessBuilder("pandoc", TMP_DIR + "/result.md", "-s", "-o", TMP_DIR + "/result.pdf");
      final Process p=pb.start();
      BufferedReader br=new BufferedReader(
              new InputStreamReader(
                      p.getInputStream()));
      String line;
      while((line=br.readLine())!=null){
        System.out.println(line);
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
