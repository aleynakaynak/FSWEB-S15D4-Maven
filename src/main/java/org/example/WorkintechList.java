package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class WorkintechList<T> extends ArrayList<T> {
    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        return super.add(value);
    }

    @Override
    public void add(int index, T value) {
        if (!contains(value)) {
            super.add(index, value);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        boolean changed = false;
        for (T value : values) {
            changed |= add(value);
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        boolean changed = false;
        int insertionIndex = index;
        for (T value : values) {
            if (!contains(value)) {
                super.add(insertionIndex++, value);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public T set(int index, T value) {
        int existingIndex = indexOf(value);
        if (existingIndex != -1 && existingIndex != index) {
            return get(index);
        }
        return super.set(index, value);
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        super.sort((left, right) -> ((Comparable<T>) left).compareTo(right));
    }

    @Override
    public boolean remove(Object value) {
        boolean removed = super.remove(value);
        if (removed) {
            sort();
        }
        return removed;
    }
}