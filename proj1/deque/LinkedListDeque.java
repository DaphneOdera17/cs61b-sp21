package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        private T item;
        private Node front; /* 前驱节点 */
        private Node next; /* 后继节点 */
        private Node(T i, Node n) {
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.front = sentinel;
    }

    public void addFirst(T val) {
        Node first = sentinel.next; /* if empty, it equals sentinel */
        Node newNode = new Node(val, first); /* The Node which is appended in the deque first, has a suffix Node sentinel */
        first.front = newNode;
        sentinel.next = newNode;
        newNode.front = sentinel;
        size ++;
    }

    public void addLast(T val) {
        Node last = sentinel.front; /* if empty, it equals sentinel */
        Node newNode = new Node(val, sentinel);
        last.next = newNode;
        newNode.front = last;
        sentinel.front = newNode;
        size ++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.front = sentinel;
        size --;
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = sentinel.front.item;
        sentinel.front = sentinel.front.front;
        sentinel.front.next = sentinel;
        size --;
        return last;
    }

    public void printDeque() {
        Node current = sentinel.next;
        while (current != sentinel) { /* important!!! */
            /* Another way: current.item != null */
            System.out.println(current.item);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
           return null;
        }
        int tmpIndex = 0;
        for (Node cur = sentinel.next; cur != sentinel; cur = cur.next) {
            if(tmpIndex != index) {
                tmpIndex += 1;
            } else {
                return cur.item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<>();
        test.addFirst(5);
        test.printDeque();
        test.addFirst(7);
        test.printDeque();
        test.addLast(10);
        test.printDeque();
    }
}
