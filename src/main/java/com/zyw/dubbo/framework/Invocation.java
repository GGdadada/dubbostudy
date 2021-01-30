package com.zyw.dubbo.framework;

import java.io.Serializable;

/**
 * @Package: com.zyw.dubbo.framework <br>
 * @description: 方法描述
 * @ClassName: Invocation <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 18:42 <br>
 */
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
