package neetcode150.easy;

import java.util.*;

public class N104_MaximumDepthOfBinaryTree {

    static class Node{
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) {this.val = val;}
        Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
    }

    // iterative breath first search
    public static int maxDepthBFS(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);
        int levels = 0;
        while(!queue.isEmpty()) {
            int elementsAtLevel = queue.size();
            for(int i=0; i<elementsAtLevel; i++) {
                Node n = queue.poll();
                if(n.left != null) {queue.add(n.left);}
                if(n.right != null) {queue.add(n.right);}
            }
            levels++;

        }

        return levels;
    }

    // iterative depth first search
    public static int maxDepthDFS(Node root) {

        if(root == null) {return 0;}

        Stack<Map.Entry<Node, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 1));

        int depth = 0;
        while(!stack.empty()) {
            Map.Entry<Node, Integer> entry = stack.pop();
            int currentDepth = (Integer) entry.getValue();
            Node n = (Node) entry.getKey();


            depth = Math.max(depth, currentDepth);

            if(n.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(n.left, currentDepth+1));
            }
            if(n.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(n.right, currentDepth+1));
            }
        }
        return depth;
    }

    // recursive solution
    public static int maxDepth(Node node) {

        if(node == null) {return 0;}

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
    // time O(n) space O(h) where h is height of tree

    public static void main(String[] args) {
        Node tree = new Node(3, new Node(9), new Node(20, new Node(15), new Node(7)));

        System.out.println(maxDepth(tree));
        System.out.println(maxDepthBFS(tree));
        System.out.println(maxDepthDFS(tree));

    }
}
