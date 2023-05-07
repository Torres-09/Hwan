package hwan.demo.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

    @Test
    void 다나와_가격정보가져오기() throws IOException {
        String url = "https://prod.danawa.com/info/?pcode=19702361&keyword=%EB%A1%9C%EB%B3%B4%EB%9D%BDs8&cate=10246321&_gl=1*1u06tzj*_ga*Mjk5NjcxOTE0LjE2NjMwNDk0NDA.*_ga_L8D5P2KD8Z*MTY4MzQ2MzMzOS4zLjEuMTY4MzQ2MzM3OS4yMC4wLjA.";

        Document doc = Jsoup.connect(url).get();

        Elements price = doc.select("tbody.high_list tr.add_delivery td.price em.prc_t");
        System.out.println(price.text());
//        price.eachText().forEach(System.out::println);
    }
}
