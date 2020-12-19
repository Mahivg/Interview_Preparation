package com.vg.DSImplementation;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {

    private class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry() {}

        public Entry(K key, V value, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Entry<K,V>[] buckets;
    private final Integer INITIAL_CAPACITY = 16;
    private Integer size = 0;

    public MyHashMap() {
        this.buckets = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        Entry<K,V> newEntry = new Entry<>(key, value, null);
        int hash = key.hashCode() % this.buckets.length;
        Entry<K, V> existing = this.buckets[hash];

        if(existing == null) {
            buckets[hash] = newEntry;
            size++;
        } else {
            while (existing.next != null) {
                if(existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if(existing.key.equals(key)) {
                existing.value = value;
                return;
            }else {
                existing.next = newEntry;
                size++;
            }
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % this.buckets.length;
        Entry<K,V> existing = this.buckets[hash];
        if(existing != null) {
            while (existing != null) {
                if(existing.key.equals(key)) {
                    return existing.value;
                }
                existing = existing.next;
            }
        }
        return null;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Integer size() {
        return size;
    }

    public List<K> getKeys() {
        List<K> keys = new ArrayList<>(size);
        for(int i = 0; i < buckets.length; i++) {
            Entry<K,V> entry = buckets[i];
            while(entry != null) {
                keys.add(entry.key);
                entry = entry.next;
            }
        }
        return keys;
    }
    public List<V> getValues() {
        List<V> values = new ArrayList<>(size);
        for(int i = 0; i < buckets.length; i++) {
            Entry<K,V> entry = buckets[i];
            while(entry != null) {
                values.add(entry.value);
                entry = entry.next;
            }
        }
        return values;
    }



}
