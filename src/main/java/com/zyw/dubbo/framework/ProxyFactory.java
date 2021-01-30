package com.zyw.dubbo.framework;

import com.zyw.dubbo.framework.protocol.http.HttpClient;
import com.zyw.dubbo.framework.register.RemoteMapRegister;
import com.zyw.dubbo.provider.api.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Random;

/**
 * @Package: com.zyw.dubbo.framework <br>
 * @description: 方法描述
 * @ClassName: ProxyFactory <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 23:23 <br>
 */
public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), objects);

                HttpClient httpClient = new HttpClient();
                List<URL> list = RemoteMapRegister.get(interfaceClass.getName());
                URL url = loadBalance(list);
                String res = httpClient.send(url.getHostName(), url.getPort(), invocation);
                return res;
            }
        });
    }

    //随机负载均衡
    public static URL loadBalance(List<URL> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
