package com.hackerDS.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowestCommonAncestor {
    //https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem


    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        List<Node> v1List = fetchAncestors(v1, root);
        List<Node> v2List = fetchAncestors(v2, root);
        if(v1List.size() > v2List.size()) {
            for(int i=v2List.size()-1;i>=0;i--) {
                if(v1List.contains(v2List.get(i))) {
                    return v2List.get(i);
                }
            }
        } else {
            for(int i=v1List.size()-1;i>=0;i--) {
                if(v2List.contains(v1List.get(i))) {
                    return v1List.get(i);
                }
            }
        }
        return root;
    }

    private static List<Node> fetchAncestors(int v1, Node cur) {
        List<Node> v1List = new ArrayList<>();
        while(cur.data != v1) {
            v1List.add(cur);
            if(v1 > cur.data) {
                cur = cur.right;
            } else if(v1 < cur.data){
                cur = cur.left;
            } else {
                break;
            }
        }
        v1List.add(cur);
        return v1List;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
