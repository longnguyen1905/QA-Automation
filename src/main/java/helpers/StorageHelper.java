package helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constants.ConstantGlobal;
import drivers.DriverManager;
import lombok.Getter;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import utils.LogUtils;

public class StorageHelper {
    @Getter
    private String token;
    @Getter
    private String userData;
    private LocalStorage localStorage;
    private WebStorage webStorage;
    private JsonParser jsonParser;
    private JsonObject clientConfigs;

    public StorageHelper(){
        webStorage = (WebStorage) new Augmenter().augment(DriverManager.getDriver());
        localStorage = webStorage.getLocalStorage();
        jsonParser = new JsonParser();
    }
    public void setLocalStorageProperties() {
        LogUtils.info("Set Token And User Data Properties ...");
        PropertiesHelper.setFile("src/test/resources/configs/token.properties");
        PropertiesHelper.setValue("TOKEN", localStorage.getItem("token"));
        PropertiesHelper.setValue("USER_DATA", localStorage.getItem("userdata"));
        PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
    }
    public String getCountryCode(){
        clientConfigs = (JsonObject) jsonParser.parse(localStorage.getItem("clientConfigs"));
        LogUtils.info("Country code is: " + clientConfigs.get("countryCode").toString());
        return clientConfigs.get("countryCode").toString();
    }
    public String getLanguageCode(){
        clientConfigs = (JsonObject) jsonParser.parse(localStorage.getItem("clientConfigs"));
        LogUtils.info("Language code is: " + clientConfigs.get("languageCode").toString());
        return clientConfigs.get("languageCode").toString();
    }
    public void loginByToken(){
        LogUtils.info("Login by token local Storage ... ");
        localStorage.setItem("token", ConstantGlobal.TOKEN);
        localStorage.setItem("userdata", ConstantGlobal.USER_DATA);
        DriverManager.getDriver().navigate().refresh();
    }
}
