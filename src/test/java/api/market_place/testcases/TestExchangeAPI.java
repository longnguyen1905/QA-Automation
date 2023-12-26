package api.market_place.testcases;

import api.market_place.payloads.ExchangePayload;
import api.market_place.ultilities.DataProvidersMarketApi;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static api.market_place.endpoints.ExchangeEndPoints.postExchange;
import static org.hamcrest.Matchers.equalTo;

public class TestExchangeAPI {

    @Test(dataProvider = "ValidExchange", dataProviderClass = DataProvidersMarketApi.class)
    public void validExchange(String fromCurrency, String toCurrency, String amount){
        ExchangePayload exchangePayload = new ExchangePayload();
        exchangePayload.setFromCurrency(fromCurrency);
        exchangePayload.setToCurrency(toCurrency);
        exchangePayload.setAmount(Double.parseDouble(amount));
        exchangePayload.setRequestId(RandomStringUtils.random(12));

        Response response = postExchange(exchangePayload);
        response.then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8");
    }

    @Test(dataProvider = "InvalidExchange", dataProviderClass = DataProvidersMarketApi.class)
    public void InvalidExchange(String fromCurrency, String toCurrency, String amount, String message, String code){
        ExchangePayload exchangePayload = new ExchangePayload();
        exchangePayload.setFromCurrency(fromCurrency);
        exchangePayload.setToCurrency(toCurrency);
        exchangePayload.setAmount(Double.parseDouble(amount));
        exchangePayload.setRequestId(RandomStringUtils.random(12));

        Response response = postExchange(exchangePayload);
        response.then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo(message))
                .body("code", equalTo(code));
        response.prettyPrint();
    }

    @Test()
    public void InvalidExchangeWithLetters(){
        String exchangePayload = "{\"fromCurrency\":\"TON\",\"amount\":\"asdsEDF$%45\",\"toCurrency\":\"TON\",\"requestId\":\"d19fb9ef-75e9-4f5d-9368-sdsd\"}";

        Response response = postExchange(exchangePayload);
        response.then()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("InvalidAmount"))
                .body("code", equalTo("InvalidAmount"));
    }

}
