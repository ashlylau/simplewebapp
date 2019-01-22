package ic.doc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static ic.doc.WebServer.TMP_DIR;

public class MarkdownFileGenerator {
  
  private String query;
  private String answer;
  
  public MarkdownFileGenerator(String query, String answer) {
    this.query = query;
    this.answer = answer;
  }
  
  public void generate() throws IOException {
    FileWriter fileWriter = new FileWriter(TMP_DIR + "/result.md");
    PrintWriter writer = new PrintWriter(fileWriter);
    
    writer.println("# " + query + "\n");
    
    if (answer == null || answer.isEmpty()) {
      writer.println("## Sorry ");
      writer.println("### Sorry, we didn't understand *" + query + "*.\n");
    } else {
      writer.write("### " + answer + "\n");
    }
    
    writer.close();
    fileWriter.close();
  }
}