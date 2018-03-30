package com.learningsJava;

public class EachEntry <K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

//    public EachEntry<K, V> getNext() {
//        return next;
//    }
//
//    public void setNext(EachEntry<K, V> next) {
//        this.next = next;
//    }

    //EachEntry<K,V> next;

    EachEntry(K key, V value) {
        this.key = key;
        this.value = value;
        //this.next = next;
    }
}
