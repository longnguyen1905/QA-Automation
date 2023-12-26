package api.market_place.ultilities;

import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProvidersMarketApi {
    private ExcelHelper excelHelper;

    @DataProvider(name = "ValidExchange")
    public Object[][] getValidData(){
        excelHelper = new ExcelHelper();
        Object[][] apidata = excelHelper.getExcelData("src/test/resources/datatest/ExchangeAPI.xlsx", "Valid");
        return apidata;
    }

    @DataProvider(name = "InvalidExchange")
    public Object[][] getInvalidData(){
        excelHelper = new ExcelHelper();
        Object[][] apidata = excelHelper.getExcelData("src/test/resources/datatest/ExchangeAPI.xlsx", "Invalid");
        return apidata;
    }
}
