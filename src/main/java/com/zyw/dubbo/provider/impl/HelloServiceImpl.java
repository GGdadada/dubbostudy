package com.zyw.dubbo.provider.impl;

import com.zyw.dubbo.provider.api.HelloService;

/**
 * @Package: com.zyw.dubbo.provider.impl <br>
 * @description: 方法描述
 * @ClassName: HelloServiceImpl <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 17:51 <br>
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String msg) {
        return "Hello " + msg;
    }
}
