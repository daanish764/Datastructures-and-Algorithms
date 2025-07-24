package neetcode150.easy;


public class N141_LinkedListCycle {

    static class Node{
        int val;
        Node next;

        Node() {};
        Node(int val){this.val = val;}
        Node(int val, Node next) {this.val = val; this.next = next;}
    }

    // time complexity = 0(n)
    // space complexity = O(1)
    public static boolean hasCycle(Node n) {

        Node slow = n;
        Node fast = n;

        while(fast != null && fast.next != null) {

            slow =  slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true; // cycle detected
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(hasCycle(n1));
    }

}
