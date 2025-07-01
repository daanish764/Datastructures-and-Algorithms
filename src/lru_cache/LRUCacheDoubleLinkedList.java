package lru_cache;

import java.util.HashMap;

public class LRUCacheDoubleLinkedList {
    Node head;
    Node tail;
    HashMap<Integer, Node> hm;
    int capacity;

    LRUCacheDoubleLinkedList(int size) {
        this.capacity = size;
        hm = new HashMap<>(size);
    }

    int get(int key) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);

            if(head != node) {
                Node prev = node.prev; // 2
                Node next = node.next; // null
                prev.next = next; // 2 -> null
                if(next != null) {
                    next.prev = prev;
                }
                node.next = head;
                head.prev = node;
                if(node == tail) {
                    tail = prev;
                }
                node.prev = null;
                head = node;
            }

            return node.value;
        }
        else {
            return -1;
        }
    }

    void put(int key, int value) {
        if(hm.containsKey(key)) {
            // update the value if key already exits
            Node n = hm.get(key);
            n.value = value;

            // move the node to the front
            if(head != n) {
                Node prev = n.prev;
                Node next = n.next;
                prev.next = next;
                if(next!=null) {
                    next.prev = prev;
                }

                n.next = head;
                if(head != null)
                    head.prev = n;
                n.prev = null;
                head = n;
            }
        }
        else {
            Node n = new Node(key, value);

            if(head == null) {
                head = n;
                tail = n;
            }
            else {

                if(hm.size() == capacity) {
                    evict();
                }

                head.prev = n;
                n.next = head;
                head = n;
            }
            hm.put(key, n);

        }
    }


    public void evict() {
        if (hm.isEmpty()) {
            return;
        }

        // Remove the least recently used node (tail) from the HashMap
        hm.remove(tail.key);

        // If there's only one element in the cache
        if (head == tail) {
            head = tail = null;  // Reset the list to empty
        } else {
            // Remove the last element in the doubly linked list and readjust pointers
            Node prev = tail.prev;
            prev.next = null;  // Disconnect the previous node from the tail
            tail.prev = null;  // Clear the previous pointer of the tail
            tail = prev;  // Move the tail pointer to the previous node
        }
    }

    void print() {
        Node n = head;
        while(n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
        System.out.println();
        n = tail;
        StringBuilder s = new StringBuilder();
        while(n != null) {
            s.append(n.value);
            s.append(" ");
            n = n.prev;
        }
        s.reverse();

        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == ' ') {
                s.replace(i, i+1, "<-");
                i+=1;
            }
        }

        System.out.println(s.toString());

    }



    public static void main(String[] args) {
        // Testing the LRU Cache
        LRUCacheDoubleLinkedList cache = new LRUCacheDoubleLinkedList(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(1)); // Returns 1
        cache.put(4, 4);  // Evicts key 2
        System.out.println(cache.get(2)); // Returns -1 (not found)
        cache.put(5, 5);  // Evicts key 3
        System.out.println(cache.get(3)); // Returns -1 (not found)
        System.out.println(cache.get(4)); // Returns 4
        System.out.println(cache.get(5));
    }
}
