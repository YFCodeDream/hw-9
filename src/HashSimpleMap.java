import java.util.Objects;

/**
 * @author YFCodeDream
 * @version 1.0.0
 * @date 2022/4/28
 * @description HashMap
 */
public class HashSimpleMap<K extends Comparable<K>, V> implements SimpleMap<K, V> {
    private final HashUSet<Entry> entryHashUSet;

    public HashSimpleMap() {
        entryHashUSet = new HashUSet<>();
    }

    @Override
    public int size() {
        return entryHashUSet.size();
    }

    @Override
    public boolean isEmpty() {
        return entryHashUSet.isEmpty();
    }

    @Override
    public V get(K key) {
        return entryHashUSet.find(new Entry(key, null)).value;
    }

    @Override
    public V put(K key, V value) {
        Entry currentEntry = entryHashUSet.find(new Entry(key, null));
        if (currentEntry == null) {
            entryHashUSet.add(new Entry(key, value));
            return null;
        }
        entryHashUSet.remove(currentEntry);
        entryHashUSet.add(new Entry(key, value));
        return currentEntry.value;
    }

    @Override
    public V remove(K key) {
        Entry removedEntry = entryHashUSet.find(new Entry(key, null));
        if (removedEntry == null) {
            return null;
        }
        entryHashUSet.remove(removedEntry);
        return removedEntry.value;
    }

    @Override
    public boolean contains(K key) {
        Entry currentEntry = entryHashUSet.find(new Entry(key, null));
        return currentEntry != null;
    }

    @Override
    public String toString() {
        return "HashSimpleMap{" +
                "entryHashUSet=" + entryHashUSet +
                '}';
    }

    @SuppressWarnings("unchecked")
    public class Entry implements Comparable<Entry>{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry entry) {
            return key.compareTo(entry.key);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
