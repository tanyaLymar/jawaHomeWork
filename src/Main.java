

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int valueNumber = new Random().nextInt(2, 10);
        System.out.println(valueNumber);
        System.out.println(triangularNumber(valueNumber));
        System.out.println(factorial(valueNumber));
        System.out.println();
        simpleNumber(1000);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int firstNumber = scanner.nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = scanner.nextInt();
        System.out.println("Выберите операцию (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        System.out.println("Ответ: " + calc(firstNumber, secondNumber, operator));
    }
    /* 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/
    static int triangularNumber(int x) {
        return x * (x + 1) / 2;
    }

    static int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }


    /* 2. Вывести все простые числа от 1 до 1000 */


     static void simpleNumber(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                for (int j = 2; i * j < arr.length; j++) {
                    arr[i * j] = false;
                }
                System.out.printf("%d ", i);
            }
        }
    }

    /* 3. Реализовать простой калькулятор

    Введите первое число: 12
    Введите операцию: +
    Введите второе число: 1
    Ответ: 13 */

    static double calc(int a, int b, char op) {
        double result = 0.0;
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                try{
                    result = (double) a / b;
                } catch(ArithmeticException e) {
                    throw  new ArithmeticException("На ноль делить нельзя!!!");
                }
            }
            default -> throw new IllegalArgumentException("Ошибка! Некорректная операция.");
        }
        return result;
    }
}