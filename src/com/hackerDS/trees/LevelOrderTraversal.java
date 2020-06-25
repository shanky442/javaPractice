package com.hackerDS.trees;

import java.util.Scanner;

import static com.hackerDS.trees.HeightBinaryTree.height;

public class LevelOrderTraversal {

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
        scan.close();
        printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        if(root!=null) {
            int height = height(root);
            for(int i=0;i<=height;i++) {
                printGivenLevel(root, i);
            }
        }
    }

    private static void printGivenLevel(Node root, int i) {
        if(root==null) return;
        if(i==0) {
            System.out.print(root.data+" ");
        } else {
            printGivenLevel(root.left,i-1);
            printGivenLevel(root.right, i-1);
        }
    }
}
