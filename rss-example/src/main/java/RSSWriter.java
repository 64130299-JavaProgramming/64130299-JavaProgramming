import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RSSWriter {
    private BufferedWriter writer;

    public RSSWriter(String filePath) throws IOException {
        writer = new BufferedWriter(new FileWriter(filePath));
        // Ghi phần đầu của file XML
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.newLine();
        writer.write("<rss>");
        writer.newLine();
        writer.write("<channel>");
        writer.newLine();
    }

    public void writeTitle(String title) throws IOException {
        writer.write("    <item>");
        writer.newLine();
        writer.write("        <title>" + title + "</title>");
        writer.newLine();
    }

    public void writeLink(String link) throws IOException {
        writer.write("        <link>" + link + "</link>");
        writer.newLine();
        writer.write("    </item>");
        writer.newLine();
    }

    public void close() throws IOException {
        writer.write("</channel>");
        writer.newLine();
        writer.write("</rss>");
        writer.close();
    }
}
