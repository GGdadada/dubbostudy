package com.zyw.dubbo.framework.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.zyw.dubbo.framework.Invocation;
import com.zyw.dubbo.framework.register.LocalServiceRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Package: com.zyw.dubbo.framework.protocol.http <br>
 * @description: 方法描述
 * @ClassName: HttpServletHandler <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 18:39 <br>
 */
public class HttpServletHandler {

    public void handler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //处理请求
        Invocation invocation = JSONObject.parseObject(request.getInputStream(), Invocation.class);
        String interfaceName = invocation.getInterfaceName();

//        LocalServiceRegister register = new LocalServiceRegister();
        Class implClass = LocalServiceRegister.getImplClass(interfaceName);

        try {
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String res = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            IOUtils.write(res, response.getOutputStream());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
