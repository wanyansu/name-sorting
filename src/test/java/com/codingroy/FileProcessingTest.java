package com.codingroy;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessingTest {

    @Test
    void outputCorrectFilePath() {
        var testPath1 = "names-test1.txt";
        var expectedPath1 = "names-test1";
        assertEquals(expectedPath1, FileProcessing.processFileName(testPath1));
        var testPath2 = "./fullnames.txt";
        var expectedPath2 = "fullnames";
        assertEquals(expectedPath2, FileProcessing.processFileName(testPath2));
        var testPath3 = "./src/main/random_names.txt";
        var expectedPath3 = "random_names";
        assertEquals(expectedPath3, FileProcessing.processFileName(testPath3));
    }

    @Test
    void outputListAccordingToFile() {
        var testFile1 = "./src/main/resources/inputfiles/testfiles/names-test1.txt";
        List<Person> testList1;
        testList1 = FileProcessing.readText(testFile1);
        assertEquals("DOE, JOHN", testList1.get(0).getName());
        assertEquals("CARTER, VINCE", testList1.get(1).getName());
        assertEquals("CARTER, ASHLEY", testList1.get(2).getName());
        assertEquals("MCGRADY, TRACY", testList1.get(3).getName());

        var testFile2 = "./src/main/resources/inputfiles/testfiles/names-test2.txt";
        List<Person> testList2;
        testList2 = FileProcessing.readText(testFile2);
        assertEquals("IVERSON, ALLEN", testList2.get(0).getName());
        assertEquals("LEE, DAVID", testList2.get(1).getName());
        assertEquals("WALKER, KYLE", testList2.get(2).getName());
        assertEquals("PIRES, ROBERT", testList2.get(3).getName());
    }

    @Test
    void assertSorting() throws IOException {
        var testFile1 = "./src/main/resources/inputfiles/testfiles/names-test1.txt";
        List<Person> testList1;
        testList1 = FileProcessing.readText(testFile1);
        Comparator<Person> lastThenFirst = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName);
        FileProcessing.saveToFile("names-test1", testList1, lastThenFirst);
        File expectedFile = new File("./src/main/resources/outputs/expected-test1.txt");
        File returnedFile = new File("./src/main/resources/outputs/names-test1-sorted.txt");
        assertThat(expectedFile).hasSameTextualContentAs(returnedFile);
    }
}