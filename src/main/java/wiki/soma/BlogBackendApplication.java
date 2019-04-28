package wiki.soma;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:17 2018/10/30
 * @modified By:
 * @copyright by sunlands
 */
@Slf4j
@Controller
@SpringBootApplication()
public class BlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendApplication.class);
    }


}
