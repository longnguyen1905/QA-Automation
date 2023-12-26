package helpers;

import utils.LogUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class NordVPNHelper {
    public static void switchCountry(String locale){
        LogUtils.info("Connect VPN to country " + locale);
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File("C:\\Program Files\\NordVPN"));
        processBuilder.command("cmd.exe", "/c", "nordvpn -c -g '"+ locale +"'");
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                LogUtils.info(line);
            }
            int exitCode = process.waitFor();
            LogUtils.info("\nExited with error code : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void disconnectVPN(){
        LogUtils.info("Disconnect VPN");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File("C:\\Program Files\\NordVPN"));
        processBuilder.command("cmd.exe", "/c", "nordvpn -d");
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                LogUtils.info(line);
            }
            int exitCode = process.waitFor();
            LogUtils.info("\nExited with error code : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
