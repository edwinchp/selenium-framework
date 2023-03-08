package resources.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private Properties prop;

    public TestProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//properties//global-data.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Properties getProperties(){
        return prop;
    }

}
