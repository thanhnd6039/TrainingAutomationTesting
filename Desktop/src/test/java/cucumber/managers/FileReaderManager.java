package cucumber.managers;

import cucumber.data_providers.ConfigFileReader;
import cucumber.data_providers.JsonDataReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;


    private FileReaderManager(){
        
    }

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader(){
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public JsonDataReader getJsonDataReader(){
        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
    }
}
