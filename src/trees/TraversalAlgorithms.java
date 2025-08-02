package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TraversalAlgorithms {

    static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val){ this.val = val; }
        Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
    }

    static class RecursiveTraversals {

        static ArrayList<Integer> result;

        public static void inOrder(Node n) {

            if(n == null) {return ;}

            // visit left
            if(n.left != null) {inOrder(n.left);}
            // visit current node
            result.add(n.val);
            // visit right
            if(n.right != null) {inOrder(n.right); }

        }

        public static void preOrder(Node n) {

            if(n == null) { return; }

            // visit the current node
            result.add(n.val);
            // visit the left node
            preOrder(n.left);
            // visit the right node
            preOrder(n.right);
        }


        public static void postOrder(Node n) {

            if(n == null) { return; }

            // visit left node
            if(n.left != null) { postOrder(n.left); }
            // visit right node
            if(n.right != null) { postOrder(n.right); }
            // visit current node
            result.add(n.val);
        }
    }


    static class IterativeTraversals {

        public static List<Integer> inOrder(Node n) {

            if(n == null) { return new ArrayList<>(); }

            ArrayList<Integer> result = new ArrayList<>();
            Stack<Node> stack = new Stack<>();

            Node ptr = n;

            while(ptr!=null || !stack.isEmpty()) {
                while(ptr != null) {
                    stack.push(ptr);
                    ptr = ptr.left;
                }
                ptr = stack.pop();
                result.add(ptr.val);
                ptr = ptr.right;
            }

            return result;
        }

        public static List<Integer> preOrder(Node n) {

            if(n == null) { return new ArrayList<>(); }

            ArrayList<Integer> result = new ArrayList<>();
            Stack<Node> stk = new Stack<>();

            stk.push(n);
            while(!stk.isEmpty()) {
                Node ptr = stk.pop();
                result.add(ptr.val);
                if(ptr.right != null) {
                    stk.push(ptr.right);
                }
                if(ptr.left != null) {
                    stk.push(ptr.left);
                }
            }

            return result;
        }

        public static List<Integer> postOrder(Node n) {

            if(n == null) { return new ArrayList<>(); }

            ArrayList<Integer> result = new ArrayList<>();
            Stack<Node> stk = new Stack<>();
            Stack<Boolean> visited = new Stack<>();

            stk.push(n);
            visited.push(false);

            while(!stk.isEmpty()) {
                Node node = stk.pop();
                boolean nodeVisited = visited.pop();

                if(nodeVisited) {
                    result.add(node.val);
                } else {
                    stk.push(node);
                    visited.push(true);
                    if(node.right != null) {
                        stk.push(node.right);
                        visited.push(false);
                    }
                    if(node.left != null) {
                        stk.push(node.left);
                        visited.push(false);
                    }
                }
            }

            return result;
        }
    }


    public static void main(String [] args) {

        List<Integer> result = null;
        List<Integer> inOrderCorrectAnswer = null;
        List<Integer> preOrderCorrectAnswer = null;
        List<Integer> postOrderCorrectAnswer = null;

        Node tree = new Node(1);
        tree.right = new Node(2);
        tree.right.left = new Node(3);

        inOrderCorrectAnswer = new ArrayList<>(Arrays.asList(1, 3, 2));
        preOrderCorrectAnswer = new ArrayList<>(Arrays.asList(1, 2, 3));
        postOrderCorrectAnswer = new ArrayList<>(Arrays.asList(3, 2, 1));

        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.inOrder(tree);
        System.out.println(RecursiveTraversals.result);
        if(RecursiveTraversals.result.equals(inOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }



        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.preOrder(tree);
        System.out.println(RecursiveTraversals.result);
        if(RecursiveTraversals.result.equals(preOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }


        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.postOrder(tree);
        System.out.println(RecursiveTraversals.result);
        if(RecursiveTraversals.result.equals(postOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }



        result = IterativeTraversals.inOrder(tree);
        System.out.println(result);
        if(result.equals(inOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }

        result = IterativeTraversals.preOrder(tree);
        System.out.println(result);
        if(result.equals(preOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }


        result = IterativeTraversals.postOrder(tree);
        System.out.println(result);
        if(result.equals(postOrderCorrectAnswer)) { System.out.println("✅ Test passed!");}
        else { System.out.println("❌ Test failed."); }


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3, new Node(4), new Node(5));

        inOrderCorrectAnswer = Arrays.asList(2, 1, 4, 3, 5);
        preOrderCorrectAnswer = Arrays.asList(1, 2, 3, 4, 5);
        postOrderCorrectAnswer = Arrays.asList(2, 4, 5, 3, 1);

        // Recursive Traversals
        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.inOrder(root);
        System.out.println("Recursive In-Order: " + RecursiveTraversals.result);
        System.out.println(RecursiveTraversals.result.equals(inOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");

        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.preOrder(root);
        System.out.println("Recursive Pre-Order: " + RecursiveTraversals.result);
        System.out.println(RecursiveTraversals.result.equals(preOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");

        RecursiveTraversals.result = new ArrayList<>();
        RecursiveTraversals.postOrder(root);
        System.out.println("Recursive Post-Order: " + RecursiveTraversals.result);
        System.out.println(RecursiveTraversals.result.equals(postOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");

        // Iterative Traversals
        result = IterativeTraversals.inOrder(root);
        System.out.println("Iterative In-Order: " + result);
        System.out.println(result.equals(inOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");

        result = IterativeTraversals.preOrder(root);
        System.out.println("Iterative Pre-Order: " + result);
        System.out.println(result.equals(preOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");

        result = IterativeTraversals.postOrder(root);
        System.out.println("Iterative Post-Order: " + result);
        System.out.println(result.equals(postOrderCorrectAnswer) ? "✅ Test passed!" : "❌ Test failed.");



    }

}
