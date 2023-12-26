package api.self_service.endpoints;

public class Routes {
    public static String baseUrl = "https://ss-customer-api.tpotslotty.cc";

    /** Default */
    public static String getHealthCheckUrl = baseUrl + "/api/health";

    /** Client*/
    public static String getClientUrl = baseUrl + "/api/client";

    /**Get list games */
    public static String getListGamesUrl = baseUrl + "/api/games";

    /** Packages */
    public static String getListPackagesUrl = baseUrl + "/api/packages";
    public static String getPackageInfoUrl = baseUrl + "/api/packages/{packageId}";
    public static String getPackageFeaturesUrl = baseUrl + "/api/packages/{packageId}/features";

    /** Create ticket (buy a package)*/
    public static String createTicketUrl = baseUrl + "/api/tickets";
}
