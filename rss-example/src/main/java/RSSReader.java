import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;
import java.net.URL;

public class RSSReader {
    public static void main(String[] args) {
        try {
            // URL của RSS feed
            URL url = new URL("https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
            // Khởi tạo RSSWriter
            RSSWriter rssWriter = new RSSWriter("rss_feed.xml");

            // Tạo đối tượng SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Tạo handler để xử lý RSS feed
            DefaultHandler handler = new DefaultHandler() {
                boolean isTitle = false;
                boolean isLink = false;

                // Bắt đầu đọc thẻ XML
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("title")) {
                        isTitle = true;
                    }
                    if (qName.equalsIgnoreCase("link")) {
                        isLink = true;
                    }
                }

                // Kết thúc đọc thẻ XML
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // No action needed here for now
                }

                // Đọc nội dung giữa các thẻ
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (isTitle) {
                        String title = new String(ch, start, length);
                        System.out.println("Title: " + title);  // In tiêu đề ra console
                        try {
                            rssWriter.writeTitle(title); // Ghi tiêu đề vào file
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        isTitle = false;
                    }
                    if (isLink) {
                        String link = new String(ch, start, length);
                        System.out.println("Link: " + link);    // In liên kết ra console
                        try {
                            rssWriter.writeLink(link); // Ghi liên kết vào file
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        isLink = false;
                    }
                }
            };

            // Bắt đầu parsing RSS feed từ URL
            saxParser.parse(url.openStream(), handler);

            // Đóng RSSWriter sau khi hoàn tất
            rssWriter.close();
            System.out.println("RSS feed has been written to rss_feed.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
