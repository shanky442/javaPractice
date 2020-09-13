package com.hackerDS.trees;

import java.util.*;


class TopView2 {
    private static Map<Integer, Node> map = new TreeMap<>();
    // https://www.hackerrank.com/challenges/tree-top-view/problem
    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        class QueueNode {
            Node node;
            int horizontalDistance;

            public QueueNode(Node node, int horizontalDistance) {
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

        /**
         * Queue is created for level order traversal so that we iterate level by level and
         * from left to right so that we keep on populating map with the horizontal
         * distance as well as the node         *
         * **/
        Queue<QueueNode> queue = new LinkedList<>();
        if (null != root) {
            queue.add(new QueueNode(root, 0));
            while (!queue.isEmpty()) {
                QueueNode queueNode = queue.poll();
                if (!map.containsKey(queueNode.horizontalDistance)) {
                    map.put(queueNode.horizontalDistance, queueNode.node);
                }
                if (queueNode.node.left != null) {
                    queue.add(new QueueNode(queueNode.node.left, queueNode.horizontalDistance - 1));
                }
                if (queueNode.node.right != null) {
                    queue.add(new QueueNode(queueNode.node.right, queueNode.horizontalDistance + 1));
                }
            }
            map.forEach((k, v) -> System.out.print(v.data + " "));
        }
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
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
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
