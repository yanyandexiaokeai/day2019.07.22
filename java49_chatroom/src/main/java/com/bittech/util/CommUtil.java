package com.bittech.util;

/*
封装所有公共操作，包括加载配置文件、json操作等
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtil {
    private static final Gson GSON = new GsonBuilder().create();

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        InputStream in = CommUtil.class.getClassLoader()
                .getResourceAsStream(fileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("资源文件加载失败");
            e.printStackTrace();
            return null;
        }
        return properties;
    }

    /**
     * 将任意对象序列化为json字符串
     * @param obj
     * @return
     */
    public static String object2Json(Object obj) {

        return GSON.toJson(obj);
    }
    // private static final Gson GSON = new GsonBuilder().create();
    /**
     * 将json串反序列化为对象
     * @param jsonStr
     * @param objClz
     * @return
     */
    public static Object json2Object(String jsonStr,Class objClz) {

        return GSON.fromJson(jsonStr,objClz);
    }


}
