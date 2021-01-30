package com.zyw.dubbo.framework.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: com.zyw.dubbo.framework.protocol.http <br>
 * @description: 方法描述
 * @ClassName: DispatcherServlet <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 18:33 <br>
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求
        new HttpServletHandler().handler(req, resp);
    }
}
