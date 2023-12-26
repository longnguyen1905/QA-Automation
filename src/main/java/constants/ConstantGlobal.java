package constants;


import helpers.PropertiesHelper;

public class ConstantGlobal {
    static {
        if (PropertiesHelper.getValue("ENV").equals("live")){
            PropertiesHelper.loadLive();
        }else {
            PropertiesHelper.loadSat();
        }
    }

    public final static String BROWSER = PropertiesHelper.getValue("BROWSER");
    public final static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("HEADLESS"));
    public final static String URL = PropertiesHelper.getValue("URL");
    public final static String USERNAME = PropertiesHelper.getValue("USERNAME");
    public final static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public final static long STEP_TIME = Long.parseLong(PropertiesHelper.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public final static String ENV = PropertiesHelper.getValue("ENV");
    public final static String SCREENSHOT_FAIL = PropertiesHelper.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelper.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelper.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelper.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");
    public final static String URL_TOURNAMENT = PropertiesHelper.getValue("URL_TOURNAMENT");
    public final static String URL_TERM_AND_CONDITION = PropertiesHelper.getValue("URL_TERMS_AND_CONDITION");
    public final static String URL_RESULTS = PropertiesHelper.getValue("URL_RESULTS");
    public final static String URL_UPCOMING = PropertiesHelper.getValue("URL_UPCOMING");
    public final static String URL_EARN = PropertiesHelper.getValue("URL_EARN");
    public final static String URL_TELEGRAM = PropertiesHelper.getValue("URL_TELEGRAM");
    public final static String URL_PROFILE = PropertiesHelper.getValue("URL_PROFILE");
    public final static String URL_WITHDRAW = PropertiesHelper.getValue("URL_WITHDRAW");
    public final static String URL_TRANSACTIONS = PropertiesHelper.getValue("URL_TRANSACTIONS");
    public final static String URL_DEPOSIT = PropertiesHelper.getValue("URL_DEPOSIT");
    public final static String URL_SEARCH = PropertiesHelper.getValue("URL_SEARCH");
    public final static String URL_REFERRAL_TELE = PropertiesHelper.getValue("URL_REFERRAL_TELE");
    public final static String URL_REFERRAL_FB = PropertiesHelper.getValue("URL_REFERRAL_FB");
    public final static Boolean PROFILE = Boolean.parseBoolean(PropertiesHelper.getValue("PROFILE"));
    public final static String TON_ADDRESS = PropertiesHelper.getValue("TON_ADDRESS");
    public final static String URL_LOG_IN = PropertiesHelper.getValue("URL_LOG_IN");
    public final static String MAX_MYR = PropertiesHelper.getValue("MAX_MYR");
    public final static String MIN_MYR = PropertiesHelper.getValue("MIN_MYR");
    public final static String URL_LOGGED = PropertiesHelper.getValue("URL_LOGGED");
    public final static String HONG_KONG = PropertiesHelper.getValue("HONG_KONG");
    public final static String INDONESIA = PropertiesHelper.getValue("INDONESIA");
    public final static String THAI_LAN = PropertiesHelper.getValue("THAI_LAN");
    public final static String SINGAPORE = PropertiesHelper.getValue("SINGAPORE");
    public final static String PHILIPPINES = PropertiesHelper.getValue("PHILIPPINES");
    public final static String MALAYSIA = PropertiesHelper.getValue("MALAYSIA");
    public final static String RUSSIA = PropertiesHelper.getValue("RUSSIA");
    public final static String TOKEN = PropertiesHelper.getValue("TOKEN");
    public final static String USER_DATA = PropertiesHelper.getValue("USER_DATA");
    public final static String URL_MARKETPLACE = PropertiesHelper.getValue("URL_MARKETPLACE");
    public final static String HOOK = PropertiesHelper.getValue("HOOK");
    public final static String TEST_HOOK = PropertiesHelper.getValue("TEST_HOOK");
    public final static String MAIN_HOOK = PropertiesHelper.getValue("MAIN_HOOK");
    public final static Boolean UPLOAD_REPORT = Boolean.parseBoolean(PropertiesHelper.getValue("UPLOAD_REPORT"));;

}
