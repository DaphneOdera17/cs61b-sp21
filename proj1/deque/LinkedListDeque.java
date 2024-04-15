package deque;

public class LinkedListDeque<ElemType> {
    private StuffNode sentinel;
    private StuffNode now;
    private int size;

    private class StuffNode {
        public ElemType item;
        public StuffNode next;
        public StuffNode front;
        public StuffNode(ElemType i, StuffNode n, StuffNode node) {
            item = i;
            next = n;
            front = node;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(ElemType x) {
        StuffNode newStuff = new StuffNode(x, null, null);
        if (isEmpty()) {
            now = newStuff;
        } else {
            newStuff.next = sentinel.next;
            sentinel.next.front = newStuff;
        }
        sentinel.next = newStuff;
        size ++;
    }

    public void addLast(ElemType x) {
        StuffNode newStuff = new StuffNode(x, null, now);
        if (isEmpty()) {
            sentinel.next = newStuff;
        } else {
            now.next = newStuff;
        }
        now = newStuff;
        size ++;
    }

    public ElemType removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ElemType first = sentinel.next.item;
        if (size == 1) {
            sentinel.next = null;
            size --;
            return first;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.front = null;
        size --;
        return first;
    }

    public ElemType removeLast() {
        if (isEmpty()) {
            return null;
        }
        ElemType last = now.item;
        now = now.front;
        if (now == null) {
            sentinel.next = null;
        } else {
            now.next = null;
        }
        size --;
        return last;
    }

    public void printDeque() {
        StuffNode current = sentinel.next;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new StuffNode(null, null, null);
        now = null;
    }
}
