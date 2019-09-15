package com.learningsJava;
import java.util.*;
public class BalancedParanthessis {
    //https://www.hackerrank.com/challenges/java-stack/problem
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack();
        while (sc.hasNext()) {
            stack.clear();
            String input=sc.next();
            //Complete the code
            for(char c:input.toCharArray()) {
                if(!stack.isEmpty()) {
                    String stackGroup = checkGroup(stack.peek());
                    String inputGroup = checkGroup(c);
                    if(stackGroup.equals(inputGroup)) {
                        stack.push(c);
                    } else {
                        if(inputGroup.equals("closed")) {
                            stack.pop();
                        }
                    }
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    private static String checkGroup(Character peek) {
        String result = "open";
        if(peek.equals(')') || peek.equals('}') || peek.equals(']')) {
            result = "closed";
        }
        return result;
    }


}
