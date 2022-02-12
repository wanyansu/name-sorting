package com.codingroy;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            List persons;
            persons = FileProcessing.readText(args[0]);
            String sortedFileName = FileProcessing.processFileName(args[0]);
            Comparator<Person> lastThenFirst = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName);
            FileProcessing.saveToFile(sortedFileName, persons, lastThenFirst);
        } else if (args.length > 1) {
            System.out.println("You have entered more than one arguments.");
        } else {
            System.out.println("You will need to enter the file location of the text file with names.");
        }
    }
}
