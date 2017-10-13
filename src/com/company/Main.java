package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        long startTimer;
        long endTimer;
        Reader reader = new Reader();
        List<String> list = reader.getArray();

        startTimer = System.currentTimeMillis();
        Collections.sort(list);
        Map<String, Integer> map = counter(list);
        endTimer = System.currentTimeMillis();
        System.out.println(endTimer-startTimer);


    }

    public static Map<String, Integer> counter(List<String> list)
    {
        Map<String, Integer> map = new HashMap<>();

        for(String s: list)
        {
            if(!map.containsKey(s))
            {
                map.put(s,1);
            }
            else
            {
                map.replace(s, map.get(s)+1);
            }
        }

        return map;
    }

}
