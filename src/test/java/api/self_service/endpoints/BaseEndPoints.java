package api.self_service.endpoints;

import io.restassured.response.Response;

import static api.self_service.endpoints.Routes.*;
import static io.restassured.RestAssured.given;
public class BaseEndPoints {

    public static Response getBaseUrl(){
        Response response = given()
                .when()
                .get(baseUrl);
        return response;
    }
    public static Response getHealthCheck(){
        Response response = given()
                .when()
                .get(getHealthCheckUrl);
        return response;
    }
    public static Response getClient(){
        Response response = given()
                .when()
                .get(getClientUrl);
        return response;
    }
    public static Response getListGames(){
        Response response = given()
                .when()
                .get(getListGamesUrl);
        return response;
    }
}
