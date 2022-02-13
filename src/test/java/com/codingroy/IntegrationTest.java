package com.codingroy;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntegrationTest {

    // Test to see if the program return a sorted result as predicted
    @Test
    void checkProgramReturn() {
        File expectedFile = new File("./src/main/resources/outputs/expectedfiles/expected-integration.txt");
        File returnedFile = new File("./src/main/resources/outputs/integration-test-sorted.txt");
        assertThat(expectedFile).hasSameTextualContentAs(returnedFile);
    }
}
