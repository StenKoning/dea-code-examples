package oose.dea.datasource.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by alexanderstenkoning on 24/03/17.
 */
public class DatabaseProperties {
    Properties p = new Properties();

    public DatabaseProperties(){
        try {
            p.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
            Class.forName(p.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDNS(){
        return p.getProperty("dns");
    }

    public String getMySQL_Driver(){
        return p.getProperty("driver");
    }
}
