package org.fanyi.fanyibackend.util;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/** 在根目录下创建一个.env文件并且加入.gitignore，application.properties以中环境变量的形式引用 */
public class EnvLoader {
    public static void loadEnv(String path) throws IOException {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(path)) {
            properties.load(reader);
        }
        properties.forEach((key, value) -> {
            String keyStr = (String) key;
            String valueStr = (String) value;
            System.setProperty(keyStr, valueStr);
        });
    }
}