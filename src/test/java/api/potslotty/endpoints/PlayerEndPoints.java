package api.potslotty.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PlayerEndPoints {
    public static Response getClientInfo(){
        Response response = given()
                .when()
                .get(Routes.getClientUrl);
        return response;
    }
}
