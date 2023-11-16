package Klawa;

import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = calc(input);
        System.out.println(output);
    }

    public static String calc(String input) {
        String[] element;
        int a;
        int b;
        int result;
        String operator;

        element = input.split(" ");

        if (element.length == 1)
            throw new RuntimeException("Строка не является математической операцией");

        if (element.length != 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");

        try {
            a = Integer.parseInt(element[0]);
            b = Integer.parseInt(element[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("В выражении можно использовать только целые числа от 1 до 10 включительно");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10)
            throw new RuntimeException("В выражении можно использовать только целые числа от 1 до 10 включительно");

        operator = element[1];

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new RuntimeException("Допустимые арифметический операции: +, -, *, /.");
        }

        return String.valueOf(result);
    }
}