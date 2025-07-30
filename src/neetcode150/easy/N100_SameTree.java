package neetcode150.easy;

public class N100_SameTree {

    static class Node{
        int val;
        Node left;
        Node right;
        Node(){};
        Node(int val){this.val = val;}
        Node(int val, Node left, Node right) {this.val = val; this.left = left; this.right = right;}
    }

    public static boolean sameTree(Node p, Node q){
        if(p == null && q == null) { return true; }
        if(p == null) { return false; }
        if(q == null) { return false; }

        if(p.val != q.val) { return false; }

        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }


    public static void main(String[] args) {

        Node treeA1 = new Node(1, new Node(2), new Node(3));
        Node treeA2 = new Node(1, new Node(2), new Node(3));
        System.out.println(sameTree(treeA1, treeA2));

        Node tree1 = new Node(1, new Node(2), null);
        Node tree2 = new Node(1, null, new Node(2));
        System.out.println(sameTree(tree1, tree2));

        Node tree3 = new Node(1, new Node(2), new Node(1));
        Node tree4 = new Node(1, new Node(1), new Node(2));
        System.out.println(sameTree(tree3, tree4));

    }
}
