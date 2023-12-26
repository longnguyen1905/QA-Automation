package api.self_service.endpoints;

import api.self_service.payloads.CasinoPackages;
import io.restassured.response.Response;

import static api.self_service.endpoints.Routes.*;
import static io.restassured.RestAssured.given;

public class PackageEndPoints {

    public static Response getListPackages(){
        Response response = given()
                .when()
                .get(getListPackagesUrl);
        return response;
    }
    public static Response getPackageInfo(String packageId){
        Response response = given()
                .pathParam("packageId", packageId)
                .when()
                .get(getPackageInfoUrl);
        return response;
    }
    public static Response getPackageFeatures(String packageId){
        Response response = given()
                .pathParam("packageId", packageId)
                .when()
                .get(getPackageFeaturesUrl);
        return response;
    }
    /** This method is also similar with "Purchase a new package"*/
    public static Response CreateTicket(CasinoPackages payload){
        Response response = given()
                .when()
                .post(createTicketUrl);
        return response;
    }
}
