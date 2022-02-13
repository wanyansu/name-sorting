package com.codingroy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getCorrectName() {
        var testPerson = new Person("Wang", "Roy");
        assertEquals("Wang", testPerson.getLastName());
        assertEquals("Roy", testPerson.getFirstName());
        assertEquals("Wang, Roy", testPerson.getName());
    }
}