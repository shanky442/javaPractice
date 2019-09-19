package com.learningsJava;

import java.util.Formatter;

public class Test {
    public static void main(String[] args) {
        boolean b = true;
        Formatter formatLog = new Formatter().format("value is %s",b);
        System.out.println(formatLog.toString());
    }
}
