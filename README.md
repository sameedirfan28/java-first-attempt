# Calculator Application

A simple command-line calculator written in Java. It evaluates expressions in the form:

```
<number> <operator> <number>
```

## Supported Operators

- `+` addition
- `-` subtraction
- `*` multiplication
- `/` division

## Running

Compile and run with `javac` and `java`:

```bash
javac -d out src/main/java/com/example/CalculatorApp.java
java -cp out com.example.CalculatorApp
```

## Example Session

```text
Simple Calculator
Enter expressions like: 3 + 4 or 10 / 2
Supported operators: +  -  *  /
Type 'exit' or 'quit' to leave.
> 12 / 3
= 4.000000
> exit
Goodbye!
```
