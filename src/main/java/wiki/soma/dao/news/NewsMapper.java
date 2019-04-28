package wiki.soma.dao.news;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wiki.soma.model.News;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:25 2019/4/28
 * @modified By:
 * @copyright by sunlands
 */
@Mapper
public interface NewsMapper {

    @Select({"SELECT id, title, author FROM news WHERE id = #{id}"})
    News findById(@Param("id") Long id);

    @Select({"SELECT id, title, author FROM news"})
    List<News> findAll();

}
