package neetcode150.easy;


public class N21_MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }


    public static ListNode merge(ListNode list1, ListNode list2) {

        if(list1 == null) {return list2;};
        if(list2 == null) {return list1;};

        ListNode dummy = new ListNode();
        ListNode tail = dummy;


        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l4;

        ListNode ll1 = new ListNode(1);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);

        ll1.next = ll3;
        ll3.next = ll4;

        ListNode result = merge(l1,ll1);

    }
}
