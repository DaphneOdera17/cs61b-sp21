/* Single linked list */
public class SLList<ElemType> {
    /* The first item(if it exists) is at sentinel.next */
    private StuffNode sentinel;
    private int size;

    /* static may mean NEVERLOOKSOUTWARDS */
    private class StuffNode {
        public ElemType item;
        public StuffNode next;

        public StuffNode(ElemType i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(ElemType x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /* Adds x to the front of the list */
    public void addFirst(ElemType x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    public ElemType getFirst() {
        return sentinel.next.item;
    }

    /* Adds an item to the end of the list. */
    public void addLast(ElemType x) {
        size += 1;

        StuffNode p = sentinel;

        /* Move p unti; it reaches the end of the list. */
        while (p.next != null)
            p = p.next;

        p.next = new StuffNode(x, null);
    }

    /* Returns the size of the list that starts at IntNode p */
    private int size(StuffNode p) {
        if (p.next == null) return 1;
        return 1 + size(p.next);
    }
    public int size() {
        return size;
    }
}
