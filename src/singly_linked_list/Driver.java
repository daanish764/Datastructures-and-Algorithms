package singly_linked_list;

public class Driver {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtEnd(5);
        list.insertAtPosition(1,7);
        list.display();
        list.deleteAtPosition(1);
        list.display();
    }
}
