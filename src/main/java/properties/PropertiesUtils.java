package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final String CONFIG_FILE_PATH = "src/test/resources/config_%s.properties";

    public static String getProperty(String property) {
        String environment = System.getProperty("env", "dev");
        String configFilePath = String.format(CONFIG_FILE_PATH, environment);

        try (FileInputStream input = new FileInputStream(configFilePath);) {
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(property);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
