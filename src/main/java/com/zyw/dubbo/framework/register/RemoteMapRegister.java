package com.zyw.dubbo.framework.register;

import com.zyw.dubbo.framework.URL;
import com.zyw.dubbo.provider.api.HelloService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.zyw.dubbo.framework.register <br>
 * @description: 方法描述
 * @ClassName: RemoteMapRegister <br>
 * @Author: zyw <br>
 * @CreateDate: 2021/1/29 0:05 <br>
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);

        if (list == null || list.size() ==0) {
            list = new ArrayList<>();
            list.add(url);
        }
        REGISTER.put(interfaceName, list);
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        getFile();
        return REGISTER.get(interfaceName);
    }

    private static void saveFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("E:\\test\\register\\register.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(REGISTER);

            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("E:\\test\\register\\register.txt");
            ois = new ObjectInputStream(fis);
//            byte[] bytes = new byte[1024];
            REGISTER = (Map<String, List<URL>>) ois.readObject();
//            System.out.println(REGISTER.toString() + REGISTER.get(HelloService.class.getName()).get(0).getHostName());

            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
