package neetcode150.easy;

public class N104_MaximumDepthOfBinaryTree {

    static class Node{
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) {this.val = val;}
        Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
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

    }
}
