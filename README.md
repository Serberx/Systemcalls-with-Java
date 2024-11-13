## System Call DateTime Application

The goal of this project is to create an application that uses system calls to retrieve the current date, time, region,
and language settings from the operating system. The information should be displayed in a window, with an optional
button to refresh the displayed data.

### Overview

This application displays the current date, time, region, and language settings of the system in a JavaFX window. It
supports both Windows and Unix-based systems. A "Refresh" button allows users to manually reload this information.

### Classes and Functions Used

### 1. DateTimeCall (System Calls for Data Retrieval)

This class performs system calls to retrieve the current date, time, region, and language of the system.

    Date:
        Windows: cmd /c date /T
        Unix: bash -c date
    Time:
        Windows: cmd /c time /T
        Unix: bash -c date +%T
    Region:
        Windows: powershell.exe -Command "(Get-WinHomeLocation).HomeLocation"
        Unix: bash -c curl -s ipinfo.io | jq '.region'
    Language:
        Windows: powershell.exe -Command "(Get-WinSystemLocale).Name"
        Unix: bash -c echo $LANG

Note on System Calls: These commands start a new process on the operating system to directly fetch information from it.
They use Java’s Runtime.getRuntime().exec() and ProcessBuilder, making the application platform-independent.

### 2. CreateDateViewAndUpdate (GUI Creation and Update)

This class creates the user interface using JavaFX, displays the retrieved system data, and provides a "Refresh" button.

    TextFields (TextField): Display date, time, region, and language.
    Button (Button): The "Refresh" button fetches the system data again and updates the display.

### 3. DateTimeApplication (Application Start)

This class initializes the JavaFX application and starts the GUI window with the launch() method.
System Calls and Commands

The application uses specific commands, depending on the operating system, to fetch the date, time, region, and
language.

    System Calls: Commands executed with Runtime.getRuntime().exec() or ProcessBuilder are considered system calls because they interact with the operating system and launch external programs.
    Commands for Data Retrieval:
        date, time (Windows)
        bash, curl, echo, jq (Unix/Linux)

## Requirements

- **Java 8 or higher**
    - Make sure you have Java 8 or a more recent version installed on your system. Java 21 is currently used in the `pom.xml`.

- **JavaFX library for GUI creation**
    - The JavaFX libraries are specified as dependencies in the `pom.xml` file, so they will be automatically downloaded and configured by Maven.

- **Maven**
    - Ensure Maven is installed to manage dependencies and build the project.
Running the Application

```bash
  mvn exec:java
```
or
```bash
  mvn javafx:run
```
