package com.company;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        Reader reader = new Reader();
        WordCounter wordCounter = new WordCounter();
        List<String> list = reader.getArray();

        Map<String, Long> map = wordCounter.countWithoutStream(list);
        System.out.println(map);

        Map<String, Long> map2 = wordCounter.countWithStream(list);
        System.out.println(map2);

        Map<String, Long> map3 = wordCounter.countWithParallelStream(list);
        System.out.println(map3);
    }
}
