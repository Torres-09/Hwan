package hwan.demo.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DanawaProductCodeTest {
    /**
     * 다나와 테스트 코드입니다.
     */
    
    private static final String SEARCH_URL_FORMAT = "https://search.danawa.com/dsearch.php?k1=%s&module=goods&act=dispMain";
    private static final String INFO_URL_FORMAT = "https://prod.danawa.com/info/?pcode=%s";
    
    @Test
    void testGetProductCode() throws IOException {
        String productName = "삼성전자 갤럭시북 프로 360";
        String searchUrl = String.format(SEARCH_URL_FORMAT, productName);
        Document doc = Jsoup.connect(searchUrl).get();
        Element itemLink = doc.select("ul.product_list li.prod_item div.prod_main_info div.thumb_image").first();
        String infoUrl = itemLink.select("a").attr("href");
        String pCode = "";

        Pattern pattern = Pattern.compile("pcode=([0-9]+)&");
        Matcher matcher = pattern.matcher(infoUrl);
        if (matcher.find()) {
            String pcode = matcher.group(1);
            pCode += pcode;
        }

        String expectedProductCode = "18936371"; // 상품코드는 매번 변경될 수 있으므로, 테스트를 위해 임의의 값으로 지정합니다.
        Assertions.assertEquals(expectedProductCode, pCode);

        // 상품코드로 해당 상품 정보를 가져올 수 있는지 확인합니다.
        Document infoDoc = Jsoup.connect(String.format(INFO_URL_FORMAT, pCode)).get();
        String productNameInInfoPage = infoDoc.select("span.title").text();
        System.out.println(productNameInInfoPage);
    }
}
