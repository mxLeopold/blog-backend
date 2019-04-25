package wiki.soma.common;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: maxiao
 * @description:
 * @date: create in 11:40 2019/4/25
 * @modified By:
 * @copyright by sunlands
 */
public class Response {

    private Response() {
    }

    public static JSONObject build(int flag, String message, Object data) {
        JSONObject object = new JSONObject();
        object.put(ApiConstants.FLAG, flag);
        object.put(ApiConstants.MESSAGE, message);
        object.put(ApiConstants.DATA, data == null ? "" : data);
        return object;
    }

    public static JSONObject fail() {
        return build(ApiConstants.FLAG_FAIL, "", null);
    }

    public static JSONObject fail(String message) {
        return build(ApiConstants.FLAG_FAIL, message, null);
    }

    public static JSONObject fail(Exception e) {
        return build(ApiConstants.FLAG_FAIL, e.getMessage(), null);
    }

    public static JSONObject fail(String message, Object data) {
        return build(ApiConstants.FLAG_FAIL, message, data);
    }

    public static JSONObject ok() {
        return build(ApiConstants.FLAG_SUCCESS, ApiConstants.MESSAGE_SUCCESS, null);
    }

    public static JSONObject ok(Object data) {
        return build(ApiConstants.FLAG_SUCCESS, ApiConstants.MESSAGE_SUCCESS, data);
    }

    public static JSONObject ok(String message, Object data) {
        return build(ApiConstants.FLAG_SUCCESS, message, data);
    }


    public static JSONObject list(List data) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", data);
        return build(ApiConstants.FLAG_SUCCESS, ApiConstants.MESSAGE_SUCCESS, map);
    }

}
