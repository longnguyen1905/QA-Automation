package api.market_place.endpoints;

import api.market_place.payloads.ExchangePayload;
import constants.ConstantGlobal;
import io.restassured.response.Response;

import static api.market_place.endpoints.Routes.exchangeRateUrl;
import static api.market_place.endpoints.Routes.exchangeUrl;
import static io.restassured.RestAssured.given;

public class ExchangeEndPoints {

    public static Response getExchangeRate(){
        Response response = given()
                .when()
                .get(exchangeRateUrl);
        return response;
    }

    public static Response postExchange(ExchangePayload exchangePayload){
        Response response = given()
                .auth().oauth2(ConstantGlobal.TOKEN)
                .contentType("application/json")
                .body(exchangePayload)
                .when()
                .post(exchangeUrl);
        return response;
    }
    public static Response postExchange(String exchangePayload){
        Response response = given()
                .auth().oauth2(ConstantGlobal.TOKEN)
                .contentType("application/json")
                .body(exchangePayload)
                .when()
                .post(exchangeUrl);
        return response;
    }
}
