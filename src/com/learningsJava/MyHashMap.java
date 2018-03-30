package com.learningsJava;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {
    int size;
    List<EachEntry>[] myArray;
    MyHashMap() {
        this.size=10;
        this.myArray = new List[this.size];
        for(int i=0;i<this.size;i++) {
            this.myArray[i] = new ArrayList<EachEntry>();
        }
    }

    MyHashMap(int size) {
        this.size=size;
        this.myArray = new List[size];
        for(int i=0;i<size;i++) {
            this.myArray[i] = new ArrayList<EachEntry>();
        }
    }

    public synchronized void put(K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException();
        }
        int index = Math.abs(key.hashCode())%this.size;
        List<EachEntry> list = myArray[index];
        for(EachEntry entry:list) {
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
            }
        }
        list.add(new EachEntry(key,value));
        //myArrayList.add(index,new EachEntry(key,value, null));
    }

    public synchronized V get(K key) {
        int index = Math.abs(key.hashCode())%this.size;
        List<EachEntry> list = myArray[index];
        for(EachEntry entry:list) {
            if(entry.getKey().equals(key)) {
                return (V)entry.getValue();
            }
        }
        return null;
    }

    public synchronized void delete(K key) {
        int index = Math.abs(key.hashCode())%this.size;
        List<EachEntry> list = myArray[index];
        for(EachEntry entry:list) {
            if(entry.getKey().equals(key)) {
                list.remove(entry);
                return;
            }
        }
        System.out.println("key not present");
    }
}
