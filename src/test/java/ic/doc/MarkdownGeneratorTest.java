package ic.doc.web;

import ic.doc.MarkdownFileGenerator;
import ic.doc.QueryProcessor;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ic.doc.WebServer.TMP_DIR;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MarkdownTest {

  String query = "Hamilton";
  String answer = new QueryProcessor().process(query);

  @Test
  public void markdownQueryTest() throws Exception {
    MarkdownFileGenerator generator = new MarkdownFileGenerator(query, answer);
    generator.generate();

    String expectedValue = "Lin-Manuel Miranda";
    BufferedReader reader = new BufferedReader(new FileReader(TMP_DIR + "/result.md"));
    StringBuilder builder = new StringBuilder();
    String currentLine = reader.readLine();
    while (currentLine != null) {
      builder.append(currentLine);
//      builder.append("n");
      currentLine = reader.readLine();
    }

    reader.close();
    Files.delete(Paths.get(TMP_DIR + "/result.md"));
    assertTrue(builder.toString().contains(expectedValue));
  }
}
