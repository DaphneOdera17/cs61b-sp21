package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;
    private int size = 0;

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K Key, V Val) {
            key = Key;
            value = Val;
        }
    }

    /** Removes all of the mappings from this map. */
    public void clear() {
        root = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node node, K key) {
        if(node == null)
            return false;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            return containsKey(node.left, key);
        else if(cmp > 0)
            return containsKey(node.right, key);
        else
            return true;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            return get(node.left, key);
        else if(cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value) {
        root = put(root, key, value);
        size += 1;
    }

    private Node put(Node node, K key, V val) {
        if(node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = put(node.left, key, val);
        else if(cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.value = val;
        return node;
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
}
