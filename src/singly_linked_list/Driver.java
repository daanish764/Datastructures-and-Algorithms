package singly_linked_list;

public class Driver {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10); // 10
        list.insertAtEnd(5); // 10 5
        list.insertAtPosition(1,7); // 10 7 5
        list.display();
        list.deleteAtPosition(1); // 10 5
        list.display();
        list.insertAtEnd(2); // 10 5 2
        list.insertAtEnd(15);// 10 5 2 15

        // question: reverse a singly linked list in place
        // no extra data structures can be used.
        // operation should be done in place
        // time complexity must be O(n)
        // dont create new Nodes
        list.reverse();
    }
}
