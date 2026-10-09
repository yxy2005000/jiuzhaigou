package com.example.jiuzhaigou.utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient();

    // GET请求
    public static void getRequest(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    // POST请求（登录/注册/提交留言）
    public static void postRequest(String url, Callback callback, String... params) {
        FormBody.Builder builder = new FormBody.Builder();
        for (int i = 0; i < params.length; i += 2) {
            builder.add(params[i], params[i + 1]);
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}