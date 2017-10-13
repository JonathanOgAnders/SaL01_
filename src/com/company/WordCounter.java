package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Anders on 13-Oct-17.
 */
public class WordCounter
{
    public WordCounter(){}

    public long startAndEndTimer()
    {
        return System.currentTimeMillis();
    }

    public long calcTimer(long smallest, long biggest)
    {
        return biggest - smallest;
    }


    public Map<String, Long> countWithoutStream(List<String> list)
    {
        long startTimer = startAndEndTimer();
        Map<String, Long> map = new HashMap<>();

        Collections.sort(list);

        for(String s: list)
        {
            if(!map.containsKey(s))
            {
                map.put(s,(long) 1);
            }
            else
            {
                map.replace(s, map.get(s)+1);
            }
        }

        long endTimer = startAndEndTimer();
        System.out.println(calcTimer(startTimer, endTimer));
        return map;
    }

    public Map<String, Long> countWithStream(List<String> list)
    {
        long startTimer = startAndEndTimer();

        Map<String, Long> map = list.stream().
                sorted().
                collect(
                        Collectors.groupingBy(e -> e, Collectors.counting()));

        long endTimer = startAndEndTimer();
        System.out.println(calcTimer(startTimer, endTimer));

        return map;
    }

    public Map<String, Long> countWithParallelStream(List<String> list)
    {
        long startTimer = startAndEndTimer();

        Map<String, Long> map = list.parallelStream().
                sorted().
                collect(
                        Collectors.groupingBy(e -> e, Collectors.counting()));

        long endTimer = startAndEndTimer();
        System.out.println(calcTimer(startTimer, endTimer));

        return map;
    }
}
