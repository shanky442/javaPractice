package com.learningsJava;
import java.util.*;
import java.io.*;
public class JavaMap {
    //Complete this code or write your own from scratch

//https://www.hackerrank.com/challenges/phone-book/problem

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();

            map.put(name,phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            if(null!=map.get(s)) {
                System.out.println(s+"="+map.get(s).toString());
            } else {
                System.out.println("Not found");
            }
        }
    }
}
