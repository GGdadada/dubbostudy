package com.zyw.dubbo.provider;

import com.zyw.dubbo.framework.URL;
import com.zyw.dubbo.framework.protocol.http.HttpServer;
import com.zyw.dubbo.framework.register.LocalServiceRegister;
import com.zyw.dubbo.framework.register.RemoteMapRegister;
import com.zyw.dubbo.provider.api.HelloService;
import com.zyw.dubbo.provider.impl.HelloServiceImpl;

/**
 * @Package: com.zyw.dubbo.provider <br>
 * @description: 方法描述
 * @ClassName: Provider <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 17:50 <br>
 */
public class Provider {

    public static void main(String[] args) {
        //本地注册
//        LocalServiceRegister register = new LocalServiceRegister();
        LocalServiceRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //注册中心
        RemoteMapRegister.register(HelloService.class.getName(), new URL("localhost", 8081));

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8081);
    }
}
