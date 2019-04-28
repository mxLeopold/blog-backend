package wiki.soma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:33 2019/4/28
 * @modified By:
 * @copyright by sunlands
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {
    private Long id;
    private String title;
    private String author;
}
