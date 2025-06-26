package singly_linked_list;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class SinglyLinkedList {

    Node startNode;


    void insertAtBeginning(int data) {
        if(startNode == null) {
            startNode = new Node(data);
        }
        else {
            Node n = new Node(data);
            n.next = startNode;
            startNode = n;
        }
    }

    void insertAtEnd(int data) {

        if(startNode == null) {
            startNode = new Node(data);
            return;
        }

        Node n = startNode;
        while(n.next != null) {
            n = n.next;
        }

        n.next = new Node(data);
    }

    void insertAtPosition(int position, int value) {

        if(position == 0) {
            insertAtBeginning(value);
            return;
        }

        Node current = startNode;
        int index = 0;

        while(current!=null && index < position-1) {
            current = current.next;
            index++;
        }

        if(current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;


    }

    void display() {
        Node n = startNode;

        while(n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }

        System.out.println();
    }

    void deleteAtPosition(int position) {

        if(startNode == null) {
            System.out.println("List is empty. Cannot delete");
            return;
        }

        if(position == 0) {
            Node temp = startNode;
            startNode = startNode.next;
            temp.next = null;
            return;
        }



        Node previous = startNode;
        Node current = startNode.next;
        int index = 1;

        while(current!=null && index < position) {
            previous = current;
            current = current.next;
            index++;
        }

        if(current==null) {
            System.out.println("Position out of bound.");
            return;
        }

        previous.next = current.next;
        current.next = null;

    }

    void reverse() {

        Node previous = null;
        Node current = startNode;
        Node next;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        startNode = previous;
    }

}
