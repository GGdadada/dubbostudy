package com.zyw.dubbo.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.zyw.dubbo.framework.register <br>
 * @description: 方法描述
 * @ClassName: LocalServiceRegister <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 19:07 <br>
 */
public class LocalServiceRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void register(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class getImplClass(String interfaceName) {
        return map.get(interfaceName);
    }
}
