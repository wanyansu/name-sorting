# Sorting Names

This is a Java project that builds a command line application to take a text file (txt) path as the only argument to sort the list of names in the text file and
output a sorted text file.

## Description

__The main test case is as follows:__

Enter the file path of a text file that containes the blow names:
```
BAKER, THEODORE
SMITH, ANDREW
KENT, MADISON
SMITH, FREDRICK
```

Sort the above list of names by last name first then by first name in an alphabetical order. Print the sorted names in the console and save to a new text file
adding a string `-sorted` after the original file name. The expected contents in the output text file are as follows:
```
BAKER, THEODORE
KENT, MADISON
SMITH, ANDREW
SMITH, FREDRICK
```
## Getting Started

### Installation

Use the following command to clone the repository to your local machine:
```
git clone https://github.com/wanyansu/name-sorting.git
```
This program can be run directly via your preferred IDE (intelliJ or VS Code) by configuring to have a file path as the sole argument. To run the program in your console, use the `java` command to interact the compiled class files in the `./classes/com/codingroy/` directory by executing the `sortNames` file. To do so, use the following command in the root directory of this project:
```
java -classpath "classes" com.codingroy.sortNames <path to the input txt file> 
```

`-classpath "classes"` is to specify the folder in which all class files are saved so that the main program (sortNames.class) can be executed.

The file path argument in the end can be either a relatvie path, or a absolute path.


### Execution Log

The execution outcomes are demonstrated in the below screenshot:

<img src="images/20220213_terminal_log.png" width=800>

The generated `names-sorted.txt` is saved in the `./src/main/resources/outputs` directory.

__For video demonstration of running the program, [Click here](https://youtu.be/NlahXDRH9ec).__

### Dependencies

* Maven - package manager
* JUnit - unit testing
* AssertJ - unit testing (asserting whether contents of two files are equal)

## Testing

The logging reports of all Junit unit tests and the integration test results are saved in the `./reports` directory.

* The `PersonTest.class` file tests the getter functions of the 'Person' class to see if persons' name strings are presented correcly. All tests are passed.
* The `FileProcessing.class` file tests all main functions of handling filename (absolute and relative path) and outputing sorted list of person names. All tests are passed.
* The `IntegrationTest.class` file tests all module as a whole by comparing the predicted outcome from an input file versus the actual outcome. The test case being utilised has passed the test.

__All expected outcomes are saved in `./src/main/resources/outputs/expectedfiles` directory; All test input files are saved in `.src/main/resources/inputfiles/testfiles` directory.__
