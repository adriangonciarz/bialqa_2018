import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static PropertiesManager instance = null;
    private Properties props = new Properties();


    protected PropertiesManager() {
    }

    public static PropertiesManager getInstance() {
        if (instance == null) {
            instance = new PropertiesManager();
        }
        return instance;
    }

    public PropertiesManager loadProperties() {
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return this;
    }

    public String getDataFilePath(){
        return props.getProperty("datafile");
    }
    public String getAPIBase(){ return props.getProperty("api.uri");}
    public Integer getAPIPort(){ return Integer.valueOf(props.getProperty("api.port"));}
}
