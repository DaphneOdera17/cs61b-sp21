package deque;

public class ArrayDeque<T>  implements Deque<T>{
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        nextFirst = 4;
        nextLast = 5;

        items = (T[]) new Object[8];
    }
    public int size() {return size;}
    public int getIndex(int idx) {
        if (nextFirst + idx >= items.length - 1) {
            return nextFirst + 1 + idx - items.length;
        } else {
            return nextFirst + 1 + idx;
        }
    }
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for(int i = 0; i < size; i ++) {
            int idx = getIndex(i);
            a[capacity / 4 + i] = items[idx];
        }
        items = a;
        nextFirst = capacity / 4 - 1;
        nextLast = nextFirst + size + 1;
    }
    public void addFirst(T x) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        if(nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }
    public void addLast(T x) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextLast] = x;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }
    public T getFirst() {
        int index = getIndex(0);
        return items[index];
    }

    public T getLast() {
        int index = getIndex(size - 1);
        return items[index];
    }

    public T get(int i) {
        int index = getIndex(i);
        return items[index];
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        T tmp = getFirst();
        int idx = getIndex(0);
        items[idx] = null;
        size --;
        nextFirst = idx;
        return tmp;
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        T tmp = getLast();
        int idx = getIndex(size - 1);
        items[idx] = null;
        size --;
        nextLast = idx;
        return tmp;
    }

    public void printDeque() {
        for (T i : items) {
            System.out.println(i);
        }
    }
}
