package wiki.soma.advisor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wiki.soma.common.Response;

/**
 * 异常统一处理
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 通用异常，服务器错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject handler(Exception e) {
        // SpringMVC框架参数解析异常
        if (e instanceof MissingServletRequestParameterException) {
            log.error("接口参数缺失：", e);
            return Response.fail("接口参数缺失", e.getMessage());
        } else if (e instanceof TypeMismatchException) {
            log.error("接口参数类型不匹配：", e);
            return Response.fail("接口参数类型不匹配", e.getMessage());
        } else if (e instanceof RuntimeException) {
            log.warn("运行异常:", e);
            return Response.fail(e.getMessage());
        }
        log.error("Controller 异常：", e);
        return Response.fail("服务器异常，请稍后重试", e.getMessage());
    }

    /**
     * 业务中很多使用断言判断参数是否合法，但是有可能影响额外异常情况
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public JSONObject handler(IllegalArgumentException e) {
        log.warn("Controller 业务参数不合法：", e);
        return Response.fail(e);
    }

    /**
     * 传参类型不正确
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public JSONObject handler(HttpMessageNotReadableException e) {
        log.warn("Controller 业务参数不合法：", e);
        return Response.fail("参数不合法");
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JSONObject baseHandler(RuntimeException e) {
        log.warn("Controller 业务：", e);
        e.printStackTrace();
        return Response.fail(e);
    }

}
