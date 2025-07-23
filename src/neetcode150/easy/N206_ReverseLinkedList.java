package neetcode150.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class N206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        if(head == null) { return null; }

        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;

            current.next = previous;
            previous = current;
            current = next;

        }

        return previous;
    }

    public static ListNode reverseListRecursive(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseListRecursive(head.next);
        head.next.next=head;
        head.next = null;

        return newNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

//        ListNode result = reverseList(n1);
        ListNode result2 = reverseListRecursive(n1);


    }
}
