package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList {
    public String[] getArray() {
        return array;
    }

    private final String[] array;
    private int size;

    public StringListImpl() {
        array = new String[10];

    }

    public StringListImpl(int initSize) {
        array = new String[initSize];

    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateIndex(index);
        validateItem(item);

        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, size, array, size + 1, size - index);
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index!=size) {
            System.arraycopy(array, index+1, array, index, size-index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = array[index];
        if (index!=size) {
            System.arraycopy(array, index+1, array, index, size-index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item)!=-1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullEtemException();
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index <0||index>=size) {
            throw new InvalidIndexException();
        }
    }
}
