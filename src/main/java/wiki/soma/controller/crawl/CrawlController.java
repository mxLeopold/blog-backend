package wiki.soma.controller.crawl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.soma.common.CrawlConstants;
import wiki.soma.utils.OkHttpUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 爬虫
 *
 * @author MAXIAO
 * @date 2019年4月27日 23:20:47
 */
@Slf4j
@Log
@RestController
public class CrawlController {

    @GetMapping(value = "news")
    public String news(HttpServletRequest request) throws Exception {
        String res = OkHttpUtils.doGet(CrawlConstants.URL_36KR);
        System.out.println(res);
        return res;
    }


}
