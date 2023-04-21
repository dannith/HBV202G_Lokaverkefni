# HBV202G Final Assignment
A project skeleton for implementing the composite pattern and the observer pattern (and some sort of template method pattern) based on tests using JUnit4.

## Installation

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency.

Both the implementation and the tests are in Java package `is.hi.abj34.dto2.hbv202g`,  but in the usual separate Maven `src` directories:

- `src/main/java`:
    - `is.hi.abj34.dto2.hbv202g.`:
      - `App`: The main menu of the program, displays a UI in the command line.
      - `CreateCategory`: The UI that displays the category creation process.
      - `CreateQuestion`: The UI that displays question creation process, with 0 categories this screen is inaccessible.
      - `Category`: Category class that will be created from the `CreateCategory` UI.
      - `Question`: Question class that will be created from the `CreateQuestion` UI.
      - `QuestionSystem`: Static class that holds all the information about created categories and questions.
      
 - `src/test/java`: 
   - `is.hi.abj34.dto2.hbv202g.`:
     - `AppTest`: All the unit tests for the non static classes; `Category` and `Question`
## Building

Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).

## License

MIT License
