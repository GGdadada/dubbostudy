package com.zyw.dubbo.framework;

import java.io.Serializable;

/**
 * @Package: com.zyw.dubbo.framework <br>
 * @description: 方法描述
 * @ClassName: URL <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/28 23:59 <br>
 */
public class URL implements Serializable {

    private String hostName;

    private Integer port;

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
