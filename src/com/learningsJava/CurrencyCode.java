package com.learningsJava;
import java.util.*;
import java.text.*;

public class CurrencyCode {




        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double payment = scanner.nextDouble();
            scanner.close();

            // Write your code here.
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
            String us = nf.format(payment);
            NumberFormat nfIndia = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setCurrencySymbol("Rs.");
            dfs.setGroupingSeparator(',');
            dfs.setMonetaryDecimalSeparator('.');
            ((DecimalFormat) nfIndia).setDecimalFormatSymbols(dfs);
            String india = nfIndia.format(payment);
            NumberFormat nfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
            String china = nfChina.format(payment);
            NumberFormat nfFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            String france = nfFrance.format(payment);

            System.out.println("US: " + us);
            System.out.println("India: " + india);
            System.out.println("China: " + china);
            System.out.println("France: " + france);
        }



}
