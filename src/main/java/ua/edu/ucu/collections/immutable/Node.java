package ua.edu.ucu.collections.immutable;

// package-private class
class Node {
    private Object value;
    private Node next;

    Node() {
        value = null;
        next = null;
    }

    Node(Object val) {
        value = val;
        next = null;
    }

    Object getValue() {
        return value;
    }
    void setValue(Object value) {
        this.value = value;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
