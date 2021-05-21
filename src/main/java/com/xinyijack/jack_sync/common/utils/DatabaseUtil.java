package com.xinyijack.jack_sync.common.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public final class DatabaseUtil {
    public static boolean backup(String dbHost,  String dbUsername, String dbPassword, String dbName, String dbOutputFile, String dbFilename)
            throws IOException, InterruptedException {
        //String command = String.format("mysqldump -h%s -u%s -p%s  %s > %s%s", dbHost, dbUsername, dbPassword, dbName, outputFile, filename, filetype);
        String command = "cmd /c mysqldump -h" + dbHost + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " > " + dbOutputFile + "\\" + dbFilename;
        Process process = Runtime.getRuntime().exec(command);
        int processComplete = process.waitFor();
        return processComplete == 0;
    }

    public static boolean recover(String dbHost,  String dbUsername, String dbPassword, String dbName, String dbOutputFile, String dbFilename)
            throws IOException, InterruptedException {
        String command = "cmd /c mysql -h" + dbHost + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " < " + dbOutputFile + "\\" + dbFilename;
        Process process = Runtime.getRuntime().exec(command);
        int processComplete = process.waitFor();
        return processComplete == 0;
    }
}
