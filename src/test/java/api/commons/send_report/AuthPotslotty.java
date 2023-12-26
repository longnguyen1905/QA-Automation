package api.commons.send_report;

import helpers.PropertiesHelper;
import io.restassured.response.Response;

import static api.potslotty.endpoints.Routes.authUrl;
import static io.restassured.RestAssured.given;

public class AuthPotslotty {
    public static void createToken(){
        Response response = given()
                .header("Content-Type", "application/json; charset=utf-8")
                .body("{ \"providerData\": { \"email\": \"longuyen@alphanetworks.global\" }, \"provider\": \"mailOtp\", \"start\": \"\", \"step\": \"\" }")
                .when()
                .post(authUrl);

        String accessKey = response.jsonPath().get("accessKey").toString();
        String timestamp = response.jsonPath().get("timestamp").toString();

        Response postAuth = given()
                .header("Content-Type", "application/json; charset=utf-8")
                .body("{ \"providerData\": { \"accessKey\": \""+accessKey+"\", \"otp\": \"000000\", \"email\": \"longuyen@alphanetworks.global\", \"timestamp\": "+timestamp+" }, \"provider\": \"mailOtp\", \"start\": \"\", \"step\": \"otp\" }")
                .when()
                .post(authUrl);

        String token = postAuth.jsonPath().get("token").toString();
        PropertiesHelper.setFile("src/test/resources/configs/token.properties");
        PropertiesHelper.setValue("TOKEN", token);
        PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
    }
}
