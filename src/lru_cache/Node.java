package lru_cache;

class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
