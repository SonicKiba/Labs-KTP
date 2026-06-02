import java.util.LinkedList;

// Наша собственная хэш-таблица с методом цепочек
public class HashTable<K, V> {

    // Внутренний класс Entry (теперь не нужен отдельный файл)
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + " → " + value + ")";
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % CAPACITY);
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    if (table[index].isEmpty()) {
                        table[index] = null;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== HashTable (Задание 1) ===\n");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isEmpty()) {
                sb.append("Index ").append(i).append(": ").append(table[i]).append("\n");
            }
        }
        return sb.toString();
    }
}