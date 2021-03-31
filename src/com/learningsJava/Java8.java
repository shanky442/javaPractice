package com.learningsJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<String> band2 = Arrays.asList("ankur","ankita","pragya","sahoo").stream().filter(x->x.startsWith("a")).collect(Collectors.toList());
        band2.stream().forEach(System.out::println);

        List<String> input = Arrays.asList("a,11,12","b,21,23","v","d,1,2");
        int rows = (int)input.stream().filter(x -> x.split(",").length==3).count();
        System.out.println("rows "+rows);
        input.stream()
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])>10)
                .forEach(x->System.out.println(x[0] + " "+x[1] + " " + x[2]));
    }
}
