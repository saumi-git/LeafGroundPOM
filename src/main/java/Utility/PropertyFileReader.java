package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    private static PropertyFileReader propertyFileReader;
    private Properties properties;

    private PropertyFileReader(){
        properties=new Properties();

        try {
            FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.proprties file "+e.getMessage());
        }

    }
    public static PropertyFileReader getInstance(){
        if (propertyFileReader==null){
            propertyFileReader=new PropertyFileReader();
        }
        return propertyFileReader;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
