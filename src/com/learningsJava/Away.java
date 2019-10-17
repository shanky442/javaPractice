package com.learningsJava;

public class Away {
    public static void main(String[] args) {
        String input = "test";
        String test = "tes";
        if(input.length()==test.length()) {
            System.out.println(checkReplace(input,test));
        } else if(input.length()+1==test.length()) {
            System.out.print(removal(input, test));
        } else if(test.length()+1==input.length()) {

        }
    }

    private static boolean removal(String input, String test) {
        char[] inputChars = input.toCharArray();
        char[] testChars = test.toCharArray();
        for(int i=0;i<testChars.length;i++) {
            if(testChars[i]!=inputChars[i]) {

            }
        }
        return false;
    }

    private static boolean checkReplace(String input, String test) {
        char[] inputChars = input.toCharArray();
        char[] testChars = test.toCharArray();
        int count =0;
        for(int i=0;i<inputChars.length;i++) {
            if(inputChars[i]!=testChars[i]) {
                count++;
            }
        }
        if(count==1)
        return true;
        else return false;
    }
}
