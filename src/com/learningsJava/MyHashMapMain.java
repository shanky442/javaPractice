package com.learningsJava;

public class MyHashMapMain {

    public static void main(String[] args) {
        MyHashMap<String,String> hashMap = new MyHashMap<>(10);
        hashMap.put("Hello","world");
        hashMap.put("first","second");
        System.out.println(hashMap.get("Hello")+""+hashMap.get("first"));
        System.out.println();
        hashMap.delete("Hello");
        System.out.println(hashMap.get("Hello"));
    }
}
