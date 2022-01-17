# OOLALA Design Plan
## Cate Schick, Dania Fernandez, Carter Stonesifer

### Team Roles and Responsibilities
Cate – View
Dania – Parser class
Carter – Debugging, testing, reading and writing files

### High Level Design

#### View
##### Button.java
This basic button class will store information relating to buttons

#### Model
##### fileParser

### CRC Card Classes

#### Parser.java
This class's purpose is to parse a file and call appropriate method

|fileParser.java| |
|---|---|
|public boolean validCommand()               ||
|getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |


This class's purpose or value is to represent a customer's order:
```java
public class fileParser {
     // returns whether an entered Turtle command is valid
     public boolean validCommand();
 }
 ```
 

### Use Cases 

 * The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.
```java

```

 * The user loads a file of commands, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.
```java
 
```

 * The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
```java

```

 * The user clicks in the display window to set a new Home location.
```java

```

 * The user changes the color of the environment's background.
```java

```

