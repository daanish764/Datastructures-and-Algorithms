package neetcode150.easy;

public class N110_BalancedBinaryTree {


    static class Node{
        int val;
        Node left;
        Node right;
        public Node(){};
        public Node(int val){this.val = val;}
        public Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
    }

    public static boolean isBalanced(Node node){

        return height(node) != -1;
    }

    public static int height(Node node){
        if(node == null) { return 0; }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);


        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1) { return -1; }

        return Math.max(leftHeight, rightHeight)+1;
    }


    public static void main(String[] args) {

        Node tree1 = new Node(3, new Node(9), new Node(20, new Node(15), new Node(7)));
        System.out.println(isBalanced(tree1));

        Node tree2 = new Node(1, new Node(2, new Node(3, new Node(4), new Node(4)), new Node(3)), new Node(2));
        System.out.println(isBalanced(tree2));
    }
}
