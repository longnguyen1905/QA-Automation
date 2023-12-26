package api.potslotty.endpoints;

public class Routes {
    public static String baseUrl = "https://api.tpotslotty.cc/api";

    /** Default API **/
    public static String postUrl = baseUrl + "";
    public static String getUrl = baseUrl + "/user/{username}";
    public static String putUrl = baseUrl + "/user/{username}";
    public static String deleteUrl = baseUrl + "/user/{username}";

    /** Default API **/
    public static String getClientUrl = baseUrl +"/client";
    public static String patchPlayerUrl = baseUrl + "player/";
    public static String getNotificationUrl = baseUrl + "/sse/notification";
    public static String authUrl = baseUrl + "/auth/login";

    /** Player API **/
    public static String postPlayerUrl = baseUrl + "/player/ping";
    public static String getPlayerUrl = baseUrl + "/player/";
    public static String getPlayerReferralUrl = baseUrl + "/player/referral";

    /** Tournament API **/
    public static String getTournamentListUrl = baseUrl + "/tournament/list";
    public static String getTournamentGameUrl = baseUrl + "/tournament/{id}";
    public static String getTournamentRankUrl = baseUrl + "/tournament/ranking/{id}";
    public static String postTournamentJoinUrl = baseUrl + "/tournament/join/{id}";
    public static String postTournamentResumeUrl = baseUrl + "/tournament/resume/{id}";

    /** Game API **/
    public static String getGamesUrl = baseUrl + "/game";
    public static String getGameDetailUrl = baseUrl + "/game/{gameId}";

    /** Wallet API **/
    public static String getCurrencyWalletUrl = baseUrl + "/wallet/currencies";
    public static String getWalletUrl = baseUrl + "/wallet/";
    public static String postWalletUrl = baseUrl + "/wallet/";
    public static String getWalletTransactionUrl = baseUrl + "/wallet/transaction/{currency}";
    public static String postDepositCheckUrl = baseUrl + "/wallet/deposit/check";
    public static String postDepositUrl = baseUrl + "/wallet/deposit";
    public static String postWithdrawUrl = baseUrl + "/wallet/withdraw";





}
