package com.xinyijack.jack_sync.common.utils;

import java.io.IOException;

public final class DatabaseUtil {
    public static boolean backup(String dbHost, String dbPort, String dbUsername, String dbPassword, String dbName, String outputFile)
            throws IOException, InterruptedException {
        String command = String.format("mysqldump -h%s -p%s -u%s -p%s --add-drop-table --databases %s -r %s",
                dbHost, dbPort, dbUsername, dbPassword, dbName, outputFile);
        Process process = Runtime.getRuntime().exec(command);
        int processComplete = process.waitFor();
        return processComplete == 0;
    }
}
