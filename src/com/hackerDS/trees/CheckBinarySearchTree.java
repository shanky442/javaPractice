package com.hackerDS.trees;

public class CheckBinarySearchTree {

    //https://www.hackerrank.com/challenges/is-binary-search-tree/problem

    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(19);
        root.right = new Node(20);
        root.right.left = new Node(19);
        root.right.right = new Node(30);
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean checkBST(Node root, int min, int max) {
        if (root == null) return true;
        System.out.println("data:: "+root.data);
        if(root.left != null && (root.data <= root.left.data || root.left.data <= min)) return false;
        if(root.right != null && (root.data >= root.right.data || root.right.data>max)) return false;
        // min and max is to check if the value of the right child node is more than the parent of the node and the value of the left child node is
        // not less than the parent node value
        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }
}
