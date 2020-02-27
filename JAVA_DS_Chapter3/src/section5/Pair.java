package section5;

public class Pair<K, V> {
    private K key;
    private V value;
    public void set(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
}
