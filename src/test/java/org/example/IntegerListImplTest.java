package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    @Test
    void getArray() {
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5};

        IntegerListImpl integerList = new IntegerListImpl();
        integerList.setArray(expectedArray);

        Integer[] actualArray = integerList.getArray();

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void add() {
        IntegerListImpl integerList = new IntegerListImpl();

        integerList.add(5);
        integerList.add(10);
        integerList.add(15);

        assertEquals(5, integerList.get(0));
        assertEquals(10, integerList.get(1));
        assertEquals(15, integerList.get(2));
    }


    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void testToArray() {
    }

    @Test
    void quickSort() {
    }
}