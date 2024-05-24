package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c) {
        super(); // 调用父类 ArrayDeque 构造函数
        cmp = c;
    }

    public T max(Comparator<T> comparator) {
        if(isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for(T i : this) {
            if(comparator.compare(i, maxItem) > 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }

    public T max() {
        return max(cmp);
    }

    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        MaxArrayDeque<Integer> a = new MaxArrayDeque<>(cmp);

        for(int i = 100; i >= 0; i --) {
            a.addFirst(i);
        }

        System.out.println(a.max());
        System.out.println(a.max(cmp));
    }
}
