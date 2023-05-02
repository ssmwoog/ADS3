import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K, V> {

    private class HashNode <K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chaarr;
    private int size;
    private int m = 11;

    private int hash(K key) {
        return Math.abs(Objects.hashCode(key)) % m;
    }

    public MyHashTable() {
        size = 0;
        chaarr = new HashNode[m];

        for (int i = 0; i < m; i++) {
            chaarr[i] = null;
        }
    }

    public MyHashTable(int m) {
        size = 0;
        this.chaarr = new HashNode[m];
        this.m = m;

        for (int i = 0; i < m; i++){
            chaarr[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");

        for (HashNode<K, V> node : chaarr) {
            while (node != null) {
                builder.append(node.key.toString()).append("=").append(node.value.toString()).append(",");
                node = node.next;
            }
        }

        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append("}");
        return builder.toString();
    }

    public void put(K key, V value){
        int ind = hash(key);
        HashNode<K, V> node = chaarr[ind];

        while(node != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode<K, V> newnode = new HashNode<K, V>(key, value);
        if (chaarr[ind] == null) {
            chaarr[ind] = newnode;
        } else {
            HashNode<K, V> last = chaarr[ind];
            while (last.next != null) {
                last = last.next;
            }
            last.next = newnode;
        }
        size++;
    }
    public V get(K key){
        int Index = hash(key);
        HashNode<K, V> node = chaarr[Index];

        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public V remove(K key){
        int Index = hash(key);
        HashNode<K, V> node = chaarr[Index];
        HashNode<K, V> oldnode = null;

        while(node != null){
            if(node.key.equals(key)){
                if( oldnode == null){
                    chaarr[Index] = node.next;
                }
                else{
                    oldnode.next = node.next;
                }
                size--;
                return oldnode.value;
            }
            oldnode = node;
            node = node.next;
        }

        return null;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chaarr) {
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public boolean contains(V value){
        return this.getKey(value) != null;
    }

    public void printBucketSizes() {
        for (int i = 0; i < m; i++) {
            int bucksize = 0;
            HashNode<K, V> node = chaarr[i];
            while (node != null) {
                bucksize++;
                node = node.next;
            }
            System.out.println("Bucket " + i + " - " + bucksize + " elements");
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
