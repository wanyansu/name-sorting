package com.codingroy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileProcessing {

    public static List readText(String inputFilePath) {
        List persons = new ArrayList<>();
        String line = "";
        File originalFile = new File(inputFilePath);
        try{
            FileReader fr = new FileReader(originalFile);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine())!=null) {
                String lName = line.split(", ")[0];
                String fName = line.split(", ")[1];
                persons.add(new Person(lName, fName));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static String processFileName(String inputFilePath) {
        String fullString = inputFilePath;
        int startPosition = fullString.lastIndexOf("/");
        int endPosition = fullString.lastIndexOf(".");
        String sortedFileName = null;
        if (endPosition > -1) {
            sortedFileName = fullString.substring(startPosition + 1, endPosition);
        }
        return sortedFileName;
    }

    public static void saveToFile(String sortedFileName, List persons, Comparator sortMethod) throws IOException {
        File outputFile = new File(("./src/main/resources/outputs/" + sortedFileName + "-sorted.txt"));
        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);
        persons.stream().sorted(sortMethod).forEach(System.out::println);
        persons.stream().sorted(sortMethod).forEach(person -> {
            try {
                bw.write(person + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        System.out.println("Finished: created " + sortedFileName + "-sorted.txt");
    }
}
