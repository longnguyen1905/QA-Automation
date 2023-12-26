package api.commons.send_report;

import constants.ConstantGlobal;
import helpers.PropertiesHelper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SendReportUtils {
    @Test
    public void SendReport() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        int passedTests;
        int totalTests;
        int failedTests;
        int brokenTests;
        int skippedTests;
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("target/allure-results/generate/widgets/summary.json")));

            JSONObject jsonObject = new JSONObject(jsonString);

            JSONObject statisticObject = jsonObject.getJSONObject("statistic");

            failedTests = statisticObject.getInt("failed");
            passedTests = 1+statisticObject.getInt("passed");
            brokenTests = statisticObject.getInt("broken");
            skippedTests = statisticObject.getInt("skipped");
            totalTests = 1+statisticObject.getInt("total");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String reportURL = getReportURL();
        double percent = ((double) passedTests / totalTests) * 100;
        String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());
        String PAYLOAD_JSON = "{\n" +
                "  \"@type\": \"MessageCard\",\n" +
                "  \"@context\": \"http://schema.org/extensions\",\n" +
                "  \"summary\": \"Build Notification for Potslotty & Market place\",\n" +
                "  \"themeColor\": \"0078D7\",\n" +
                "  \"title\": \"Potslotty & Market place Automation Test: " + date + "\",\n" +
                "  \"sections\": [\n" +
                "    {\n" +
                "      \"activityTitle\": \"\",\n" +
                "      \"facts\": [\n" +
                "        {\"name\": \"ENVIRONMENT:\", \"value\": \"" + ConstantGlobal.ENV.toUpperCase() + "\"},\n" +
                "        {\"name\": \"Report Link:\", \"value\": \"" + reportURL + "\"},\n" +
                "        {\"name\": \"Tests run:\", \"value\": \"" + totalTests + "\"},\n" +
                "        {\"name\": \"Passed :\", \"value\": \"" + passedTests + "\"},\n" +
                "        {\"name\": \"Failures:\", \"value\": \"" + failedTests + "\"},\n" +
                "        {\"name\": \"Broken:\", \"value\": \"" + brokenTests + "\"},\n" +
                "        {\"name\": \"Skipped :\", \"value\": \"" + skippedTests + "\"},\n" +
                "        {\"name\": \"Percent :\", \"value\": \"" + decimalFormat.format(percent) + "%" + "\"}\n" +
                "      ],\n" +
                "      \"markdown\": true\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String WEBHOOK_URLS_STR = ConstantGlobal.TEST_HOOK;
        if (PropertiesHelper.getValue("HOOK").equals("main")){
            WEBHOOK_URLS_STR = ConstantGlobal.MAIN_HOOK;
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(WEBHOOK_URLS_STR);
        try {
            StringEntity stringEntity = new StringEntity(PAYLOAD_JSON);
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = httpClient.execute(httpPost);

            try {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    System.out.println("Response from server: " + EntityUtils.toString(responseEntity));
                }
            } finally {
                response.close();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getReportURL(){
        try {
            File myObj = new File("allure_report_url.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("Server started at")){
                    data = data.substring(19,46);
                    return data;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;

    }



}
