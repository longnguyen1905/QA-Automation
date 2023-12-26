package api.self_service.ultilities;

import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProvidersSelfServiceApi {
    private ExcelHelper excelHelper;


    @DataProvider(name = "Data")
    public Object[][] getAllData(){
        excelHelper = new ExcelHelper();
        Object[][] apidata = excelHelper.getExcelData("src/test/resources/testdata/Userdata.xlsx", "User");
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public Object[] getUserNames(){
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/Userdata.xlsx", "User");
        int rowNum = excelHelper.getLastRowNum();
        String apidata[] = new String[rowNum];
        for (int i = 0; i < rowNum; i++){
            apidata[i] = excelHelper.getCellData("UserName", i + 1);
        }
        return apidata;
    }
}
