package cucumber;

import cucumber.data_providers.ConfigFileReader;

public class SeleniumTest {

    public static void main(String[] args){
        ConfigFileReader configFileReader = new ConfigFileReader();
        String driverPath = configFileReader.getDriverPath();
        System.out.println("driverPath: "+driverPath);
        String url = configFileReader.geturl();
        System.out.println("url: "+url);
    }
}
