package wiki.soma.utils;


import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

/**
 * @author: maxiao
 * @description:
 * @date: create in 20:24 2019/4/24
 * @modified By:
 * @copyright by sunlands
 */
@Slf4j
public class OkHttpUtils implements Cloneable {

    // 20s超时
    private static final int TIME_OUT = 20;
    private static OkHttpClient client;

    // 请求类型
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public String doGet(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            return response.body().string();
        }
    }

    public void doAsyncGet(String url) throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    System.out.println(responseBody.string());
                }
            }
        });
    }

    public String doPost(String url, String json) throws Exception {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /********************************************************
     *                      单例方法区                      *
     *******************************************************/
    private OkHttpUtils() {
    }

    private static OkHttpClient getInstance() {
        // 将同步锁范围缩小，降低性能损耗
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }

    /**
     * 禁止克隆对象
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * 反序列化时返回instance实例，防止破坏单例模式
     *
     * @return
     */
    protected Object readResolve() {
        return getInstance();
    }

}
