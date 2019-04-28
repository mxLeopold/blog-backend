package wiki.soma.controller.news;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.soma.common.Response;
import wiki.soma.dao.news.NewsMapper;

import javax.annotation.Resource;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:38 2019/4/28
 * @modified By:
 * @copyright by sunlands
 */
@Slf4j
@RestController
public class NewsController {

    @Resource
    private NewsMapper newsMapper;

    @GetMapping(value = "/news/all")
    public JSONObject allNews() {
        return Response.list(newsMapper.findAll());
    }

}
