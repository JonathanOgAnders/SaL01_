package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anders on 10-Oct-17.
 */
public class Reader
{
    private Scanner scanner = new Scanner(new File("AliceInWonderland.txt"));
    private List<String> array = new ArrayList<>();

    public Reader() throws FileNotFoundException
    {
        while(scanner.hasNext())
        {
            array.add(scanner.next().replaceAll("[^\\\\p{L}\\\\p{Nd}]+]", "").toLowerCase());
        }
    }

    public List<String> getArray()
    {
        return array;
    }
}
