package com.codingroy;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class sortNames {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            List persons;
            persons = FileProcessing.readText(args[0]);

            // Receive the output filename from processing the input argument
            String sortedFileName = FileProcessing.processFileName(args[0]);

            // Create a logic to sort last name first then last name
            Comparator<Person> lastThenFirst = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName);

            // Write and save an output txt file to the output folder
            FileProcessing.saveToFile(sortedFileName, persons, lastThenFirst);
        } else if (args.length > 1) {
            System.out.println("You have entered more than one arguments.");
        } else {
            System.out.println("You will need to enter the file location of the text file with names.");
        }
    }
}
