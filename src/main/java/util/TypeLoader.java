package util;

import org.apache.commons.exec.environment.EnvironmentUtils;

import java.io.InputStream;
import java.util.Properties;

public class TypeLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {
            properties = new Properties();
            InputStream fileInput = EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH);

            if (fileInput != null) {
                properties.load(fileInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBasePathUrl() {
        return properties.getProperty("base.path.url");
    }

    public static String getApiKey() {
        return properties.getProperty("api.key");
    }
}
