package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class CalculatorApp {
    private static final String PROMPT = "> ";

    public static void main(String[] args) throws IOException {
        printWelcome();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (true) {
                System.out.print(PROMPT);
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (isExitCommand(line)) {
                    System.out.println("Goodbye!");
                    break;
                }
                try {
                    double result = evaluateExpression(line);
                    System.out.printf(Locale.US, "= %.6f%n", result);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }

    private static void printWelcome() {
        System.out.println("Simple Calculator");
        System.out.println("Enter expressions like: 3 + 4 or 10 / 2");
        System.out.println("Supported operators: +  -  *  /");
        System.out.println("Type 'exit' or 'quit' to leave.");
    }

    private static boolean isExitCommand(String line) {
        String normalized = line.trim().toLowerCase(Locale.US);
        return normalized.equals("exit") || normalized.equals("quit");
    }

    private static double evaluateExpression(String line) {
        String[] tokens = line.split("\\s+");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Expected format: <number> <operator> <number>");
        }
        double left = parseNumber(tokens[0]);
        double right = parseNumber(tokens[2]);
        String operator = tokens[1];
        return applyOperator(left, right, operator);
    }

    private static double parseNumber(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid number: " + token);
        }
    }

    private static double applyOperator(double left, double right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
