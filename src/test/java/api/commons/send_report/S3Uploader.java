package api.commons.send_report;

import constants.ConstantGlobal;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class S3Uploader {

    private static final String BUCKET_NAME = "hemgasset";
    private static final String CDN_DIRECTORY_PATH = "automation/potslotty/";
    private static final String AWS_ACCESS_KEY_ID = "AKIA433DGMBQYDXI5CFL";
    private static final String AWS_SECRET_ACCESS_KEY = "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";

    @Test
    public void uploadToCDN() {
        renameFile();
        if (ConstantGlobal.UPLOAD_REPORT == true){
            uploadFilesToS3(BUCKET_NAME, CDN_DIRECTORY_PATH, AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
        }
    }

    public static void uploadFilesToS3(String bucketName, String cdnDirectoryPath, String accessKeyId, String secretAccessKey) {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
        Region region = Region.AP_SOUTHEAST_1; // Replace with your desired AWS region

        S3Client s3 = S3Client.builder()
                .credentialsProvider(() -> awsCreds)
                .region(region)
                .build();
        String directoryPath = "allure-report/";

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String keyName = cdnDirectoryPath +directoryPath + file.getName(); // Object key in S3 (can be customized)
                        PutObjectRequest request = PutObjectRequest.builder()
                                .bucket(bucketName)
                                .key(keyName)
                                .build();

                        s3.putObject(request, Paths.get(file.getPath()));
                        System.out.println("Uploaded: " + file.getName());
                    }
                }
            } else {
                System.err.println("Directory does not exist or is empty.");
            }
        } catch (S3Exception e) {
            e.printStackTrace();
        } finally {
            s3.close();
        }
    }

    public static void renameFile(){
        String date = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
        String newName = "Report_" + date +".html";
        System.out.println(newName);

        File oldFile = new File("allure-report/index.html");
        String newFilePath = oldFile.getAbsolutePath().replace(oldFile.getName(), "") + newName;
        File newFile = new File(newFilePath);

        try {
            FileUtils.moveFile(oldFile, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}