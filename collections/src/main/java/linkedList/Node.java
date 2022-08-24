package linkedList;

class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
        next = null;
    }
}