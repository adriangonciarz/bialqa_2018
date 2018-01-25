import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import models.DataFile;
import models.User;

import java.io.FileReader;
import java.util.List;

public class TestBase {
    PropertiesManager props = PropertiesManager.getInstance().loadProperties();
    private DataFile dataFile;
    public List<User> ALL_USERS;

    public TestBase(){
        dataFile = readDataFromJsonFile();
        ALL_USERS = getAllUsers();
        RestAssured.baseURI = props.getAPIBase();
        RestAssured.port = props.getAPIPort();
    }

    private DataFile readDataFromJsonFile() {
        String FILE_PATH = props.getDataFilePath();
        DataFile df = null;
        try {
            FileReader reader = new FileReader(FILE_PATH);
            ObjectMapper objectMapper = new ObjectMapper();
            df = objectMapper.readValue(reader, DataFile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return df;
    }

    public List<User> getAllUsers(){
        return dataFile.users;
    }
}
