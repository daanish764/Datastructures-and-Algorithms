package neetcode150.easy;


public class N543_DiameterOfBinaryTree {

    static int diameter = 0;

    static class Node{
        int val;
        Node left;
        Node right;
        Node(){}
        Node(int val) {this.val = val;}
        Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
    }

    public static int diameterOfTree(Node root) {

        diameter = 0;
        maxHeight(root);
        return diameter;

    }

    public static int maxHeight(Node node) {

        if(node == null) {return 0;}

        int leftHeight = maxHeight(node.left);
        int rightHeight = maxHeight(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight)+1;

    }

    public static void main(String[] args) {

        Node tree = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3));

        System.out.println(diameterOfTree(tree));
    }
}
