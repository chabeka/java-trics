package com.kindia.solia.trics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinuxCommandLuncher {


    public static void run() {
        String linuxCommand = "ls -l";
        try
        {
            Process p = Runtime.getRuntime().exec(new String[] {"sh", "-c", linuxCommand});
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeCommand(String command) {
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
