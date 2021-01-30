package com.zyw.dubbo.framework.protocol.http;



import com.alibaba.fastjson.JSONObject;
import com.zyw.dubbo.framework.Invocation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * @Package: com.zyw.dubbo.framework.protocol.http <br>
 * @description: 方法描述
 * @ClassName: HttpClient <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 20:06 <br>
 */
public class HttpClient {

    public String send(String hostName, int port, Invocation invocation) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, hostName, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();

            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String res = response.body();
            return res;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
