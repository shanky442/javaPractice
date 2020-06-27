package com.hackerDS.trees;

import java.util.*;

public class VerticalOrderTraversal {

    static void getVerticalOrder(Node root, int hd, Map<Integer, List<Integer>> map) {
        if(root==null) return;
        List<Integer> list = map.get(hd);
        if(null==list) {
            list = new ArrayList<>();
            list.add(root.data);
        } else {
            list.add(root.data);
        }
        map.put(hd,list);
        getVerticalOrder(root.left,hd-1,map);
        getVerticalOrder(root.right,hd+1,map);
    }

    static void printVerticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        getVerticalOrder(root,0, map);
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
