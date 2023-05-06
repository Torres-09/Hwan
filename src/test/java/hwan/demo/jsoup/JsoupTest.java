package hwan.demo.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsoupTest {

    @Test
    void 구글_로고가져오기() throws IOException {
        // Google URL
        String url = "https://www.google.com/";

        // Connect to the URL and get the page content
        Document doc = Jsoup.connect(url).get();

        // Find the logo image element
        Element logo = doc.selectFirst("img.lnXdpd");

        // Get the logo image URL
        String logoUrl = logo.absUrl("src");

        // Print the logo image URL
        System.out.println(logoUrl);
    }
}
