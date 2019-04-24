package wiki.soma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:17 2018/10/30
 * @modified By:
 * @copyright by sunlands
 */
@Controller
@SpringBootApplication
public class BlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendApplication.class);
    }

    @GetMapping
    @ResponseBody
    public String hello() {
        return "HELLO WORLD";
    }

}
