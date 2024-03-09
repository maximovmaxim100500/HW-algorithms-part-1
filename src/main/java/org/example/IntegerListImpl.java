package org.example;

import com.sun.jdi.IntegerType;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    public Integer[] getArray() {
        return array;
    }

    private Integer[] array;
    private int size;

    public IntegerListImpl() {
        array = new Integer[10];

    }

    public IntegerListImpl(int initSize) {
        array = new Integer[initSize];

    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        growIfNeeded();
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        growIfNeeded();
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
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = array[index];
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arrCopy = toArray();
        SortedMethodAnalise.sortSelection(arrCopy);
        return binarySearch(arrCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public Integer[] toArray(Integer[] array) {
        return Arrays.copyOf(array, array.length);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullEtemException();
        }
    }

    private void growIfNeeded() {
        if (size == array.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    private boolean binarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private void grow () {
        array = Arrays.copyOf(array, size + size / 2);
    }

    public static void quickSort(Integer[] arr, Integer begin, Integer end) {
        if (begin < end) {
            Integer partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static Integer partition(Integer[] arr, Integer begin, Integer end) {
        Integer pivot = arr[end];
        Integer i = (begin - 1);

        for (Integer j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, Integer left, Integer right) {
        Integer temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
