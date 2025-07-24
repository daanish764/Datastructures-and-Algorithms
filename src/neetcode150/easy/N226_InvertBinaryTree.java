package neetcode150.easy;

public class N226_InvertBinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;
        Node() {};
        Node(int val) {this.val = val;}
        Node(int val, Node left, Node right){this.val = val; this.left = left; this.right = right;}

    }

    public static Node invertTree(Node head) {

        if(head == null) { return head; }

        Node temp = head.left;
        head.left = head.right;
        head.right = temp;

        invertTree(head.left);
        invertTree(head.right);

        return head;
    }



    public static void main(String[] args) {
        Node tree = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(7, new Node(6), new Node(9)));

        Node result = invertTree(tree);



    }
}
