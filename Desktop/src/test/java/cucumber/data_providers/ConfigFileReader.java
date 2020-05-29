package cucumber.data_providers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src\\test\\resources\\configs\\Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null){
            return driverPath;
        }else {
            throw new RuntimeException("driverPath is not specified in the Configuration.properties file");
        }
    }

    public String geturl(){
        String url = properties.getProperty("url");
        if(url != null){
            return url;
        }else {
            throw new RuntimeException("url is not specified in the Configuration.properties file");
        }
    }
}