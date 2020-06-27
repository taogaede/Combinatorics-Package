## Running Unit Tests

Your IDE might be able to run the unit tests with its built in plugins. If not, these instructions should get you started.

From a command line (or your IDE's terminal window), navigate to the Combinatorics-Package root directory. Then execute
the following:

To install dependencies

    gradle install

Run the tests

    gradle test
    
If you follow the directions below you can also run individual tests from your IDE

### Loading the types from your IDE
#### IntelliJ Idea
Generate a project file (you'll need to do this any time the build.gradle dependencies change)

    gradle idea

#### Eclipse
(I don't know, haven't tried it yet)
