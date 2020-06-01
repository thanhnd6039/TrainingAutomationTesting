package cucumber.data_providers;
import cucumber.enums.DriverType;
import cucumber.enums.EnvironmentType;

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

    public DriverType getBrowser(){
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")){
            return DriverType.CHROME;
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            return DriverType.FIREFOX;
        }
        else if (browserName.equalsIgnoreCase("iexplorer")){
            return DriverType.INTERNETEXPLORER;
        }
        else {
            throw new RuntimeException("Browser name key value in Configuration.properties file is not matched: "+browserName);
        }
    }

    public EnvironmentType getEnvironment(){
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")){
            return EnvironmentType.LOCAL;
        }
        else if (environmentName.equalsIgnoreCase("remote")){
            return EnvironmentType.REMOTE;
        }
        else {
            throw new RuntimeException("Environment name key value in Configuration.properties file is not matched: "+environmentName);
        }
    }

    public String getTestDataPath(){
        String testDataPath = properties.getProperty("testDataPath");
        if (testDataPath != null){
            return testDataPath;
        }else {
            throw new RuntimeException("Test Data path is not specified in the Configuration.properties file for the key: testDataPath");
        }
    }
}
