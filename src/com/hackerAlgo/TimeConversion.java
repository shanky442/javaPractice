package com.hackerAlgo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimeConversion {
    //https://www.hackerrank.com/challenges/time-conversion/problem
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

        if(s.contains("AM")) {
            s = s.split("AM")[0];
            String hour = s.split(":")[0];
            String hr = String.valueOf(hour);
            if (hour.equals("12")) {
                hr = "00";
            }
            List<String> list = new ArrayList<>(Arrays.asList(s.split(":")));
            StringBuilder finalS =new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    finalS = finalS.append(hr);
                } else finalS.append(":").append(list.get(i));
            }
            return finalS.toString();
        } else {
            s = s.split("PM")[0];
            String hr = s.split(":")[0];
            int hour =0;
            if(!(Integer.parseInt(hr)==12)) {
                hour = Integer.parseInt(hr)+12;
            } else {
                hour = 12;
            }
            List<String> list = new ArrayList<>(Arrays.asList(s.split(":")));
            StringBuilder finalS =new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    finalS = finalS.append(hour);
                } else finalS.append(":").append(list.get(i));
            }
            return finalS.toString();
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);

        /*bw.write(result);
        bw.newLine();

        bw.close();*/
    }
}
