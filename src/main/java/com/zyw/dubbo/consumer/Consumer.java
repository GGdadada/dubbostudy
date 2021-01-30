package com.zyw.dubbo.consumer;

import com.zyw.dubbo.framework.Invocation;
import com.zyw.dubbo.framework.ProxyFactory;
import com.zyw.dubbo.framework.protocol.http.HttpClient;
import com.zyw.dubbo.provider.api.HelloService;

/**
 * @Package: com.zyw.dubbo.consumer <br>
 * @description: 方法描述
 * @ClassName: Consumer <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 17:50 <br>
 */
public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String res = helloService.sayHello("dubbo test");
//        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[] {String.class}, new Object[] {"dubbo"});
//
//        HttpClient httpClient = new HttpClient();
//        String res = httpClient.send("localhost", 8081, invocation);
        System.out.println(res);
    }
}
