package api.potslotty.endpoints;

import io.restassured.response.Response;

import static api.potslotty.endpoints.Routes.getClientUrl;
import static api.potslotty.endpoints.Routes.getNotificationUrl;
import static io.restassured.RestAssured.given;

public class DefaultEndPoints {

    public static Response getClientInfo(){
        Response response = given()
                .when()
                .get(getClientUrl);
        return response;
    }
    public static Response getNotification(){
        Response response = given()
                .when()
                .get(getNotificationUrl);
        return response;
    }

}
