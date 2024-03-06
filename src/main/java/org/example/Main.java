package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        stringList.add("Str0");
        stringList.add("Str1");
        stringList.add("Str2");
        stringList.add("Str3");
        stringList.add("Str4");
        stringList.add("Str5");
        stringList.add("Str6");
        stringList.add("Str7");
        stringList.add(5, "STR");
        String[] array = stringList.toArray();
        System.out.println(Arrays.toString(array));

    }
}