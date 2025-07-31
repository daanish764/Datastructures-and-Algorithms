package neetcode150.easy;

public class N572_SubtreeOfAnotherTree {

    static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val){this.val = val;}
        Node(int val, Node left, Node right){this.val = val; this.left = left; this.right = right;}
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        if(subRoot == null) { return true; }
        if(root == null) { return false; }

        if(sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean sameTree(Node s, Node t) {
        if(s == null && t == null) { return true; }
        if(s == null || t == null) { return false; }

        if(s.val == t.val) {
            return sameTree(s.left, t.left) && sameTree(s.right, t.right);
        }

        return false;
    }

    public static void main(String[] args) {
        Node tree1 = new Node(3, new Node(4, new Node(1), new Node(2)), new Node(5));
        Node tree2 = new Node(4, new Node(1), new Node(2));
        System.out.println(isSubtree(tree1, tree2)); // true


        Node tree3 = new Node(3);
        tree3.left = new Node(4);
        tree3.right = new Node(5);
        tree3.left.left = new Node(1);
        tree3.left.right = new Node(2, new Node(0), null);
        Node tree4 = new Node(4, new Node(1), new Node(2));
        System.out.println(isSubtree(tree3, tree4)); // false
    }
}
