import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    private ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void add(T x) {
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    public boolean contains(T x) {
        for(int i = 0; i < size; i ++) {
            if(items[i].equals(x)) {
                return true;
            }
        }

        return false;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }
        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
//        String x = "{";
        StringBuilder x = new StringBuilder();
        x.append("(");
        for(T i : this) {
            x.append(i.toString()).append(" ");
        }
        x.append(")");

        return x.toString();
    }

    @Override
    public boolean equals(Object o) {
        /* checks if o is an ArraySet */
        if (o instanceof ArraySet otherArraySet) {
            if (this.size != otherArraySet.size) {
                return false;
            }
            for (T i : this) {
                if (!otherArraySet.contains(i)) {
                    return false;
                }
            }
            return true;
        }
        return false; /* o is not an ArraySet */
    }

    public static void main(String[] args) {
        ArraySet<Integer> S = new ArraySet<>();
        S.add(5);
        S.add(23);
        S.add(42);

        System.out.println(S.contains(42));
        System.out.println(S.contains(50));

        /* java 内置 set */
        Set<Integer> javaset = new HashSet<>();
        javaset.add(5);
        javaset.add(23);
        javaset.add(50);
        for(int i : javaset) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i : S) {
            System.out.println(i);
        }

        /* toString 方法 */
        System.out.println(S);
    }
}
