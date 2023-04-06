package pages.base;

import pages.LoginPage;
import resources.utils.TestProperties;

import java.util.Properties;

public class BaseClass {

    private Properties prop;
    protected LoginPage loginPage;

    protected Properties getProperties(){
        prop = new Properties();
        prop = new TestProperties().getProperties();
        return prop;
    }
}
