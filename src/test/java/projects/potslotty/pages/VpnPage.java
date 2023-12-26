package projects.potslotty.pages;

import constants.ConstantGlobal;
import helpers.StorageHelper;
import helpers.VpnHelper;
import projects.commons.BasePage;

import java.util.List;

import static keywords.Keyword.*;

public class VpnPage {
    private VpnHelper vpnHelper;
    private StorageHelper storageHelper;
    public void changeVPN(String country){
        vpnHelper = new VpnHelper();
        BasePage.createDriverVPN();
        storageHelper = new StorageHelper();
        switch (country){
            case "ms":
                vpnHelper.setAndCheckVPN(ConstantGlobal.MALAYSIA);
                break;
            case "ru":
                vpnHelper.setAndCheckVPN(ConstantGlobal.RUSSIA);
                break;
            case "th":
                vpnHelper.setAndCheckVPN(ConstantGlobal.THAI_LAN);
                break;
            case "id":
                vpnHelper.setAndCheckVPN(ConstantGlobal.INDONESIA);
                break;
            case "si":
                vpnHelper.setAndCheckVPN(ConstantGlobal.SINGAPORE);
                break;
            case "hk":
                vpnHelper.setAndCheckVPN(ConstantGlobal.HONG_KONG);
                break;
            case "php":
                vpnHelper.setAndCheckVPN(ConstantGlobal.PHILIPPINES);
                break;
        }
        openURL(ConstantGlobal.URL);
        verifyLocale(country);
    }
    public void verifyLocale(String country){
        List<String>languageCode = getDataForLocale(country, "languageCode");
        List<String>countryCode = getDataForLocale(country, "countryCode");
        verifyEquals(storageHelper.getCountryCode().replace("\"","" ).toLowerCase(),countryCode.get(0));
        verifyEquals(storageHelper.getLanguageCode().replace("\"","" ).toLowerCase(),languageCode.get(0));
    }
}
