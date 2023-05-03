import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class HomeWork2 {
    static Scanner scanner = new Scanner(System.in);
    static Logger logger;

    static {
        logger = Logger.getLogger(HomeWork2.class.getName());
        FileHandler fh = null;
        try {
            fh = new FileHandler("log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fh);
        SimpleFormatter txt = new SimpleFormatter();
        fh.setFormatter(txt);
    }

    public static void main(String[] args) throws IOException {
        // Задача 1
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();

        int[] arr = arrayFilling(size);
        printArray(arr);
        bubbleSort(arr);
        BufferedReader br = new BufferedReader(new FileReader("fileHW.txt"));
        var info = getInfo("fileHW.txt");
        printInfo(info);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int firstNumber = scanner.nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = scanner.nextInt();
        System.out.println("Выберите операцию (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        System.out.println("Ответ: " + calc(firstNumber, secondNumber, operator));
        scanner.close();
        calc(6, 0, '/');

    }


    /* Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
    результат после каждой итерации запишите в лог-файл. */
    static int[] arrayFilling(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент массива: ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) throws IOException {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logger.info("Итерация: " + (i + 1) + ". Результат: " + Arrays.toString(arr));

        }
    }

    /*Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода в консоль:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.*/
    private static List<String> getInfo(String fileName) throws IOException {
        List<String> result = new ArrayList<>(10);
        File activeFile = new File(fileName);
        try {
            FileReader fileReader = new FileReader(activeFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void printInfo(List<String> originInfo) {
        for (var item : originInfo) {
            StringBuilder resultLine = new StringBuilder();
            var tmp = ((String) item).split(",");
            resultLine.append("Студент ");
            resultLine.append(tmp[0].split(":")[1]);
            resultLine.append(" получил ");
            resultLine.append(tmp[1].split(":")[1]);
            resultLine.append(" по предмету ");
            resultLine.append(tmp[2].split(":")[1]);
            System.out.println(resultLine);
        }
    }

    static double calc(int a, int b, char op) throws IOException {
        double result;
        switch (op) {
            case '+' -> {
                result = a + b;
                logger.info("Выполненная операция: сложение. " + a + "+ " + b + " Результат: " + result);
            }
            case '-' -> {
                result = a - b;
                logger.info("Выполненная операция: вычитание. " + a + "- " + b + " Результат: " + result);
            }
            case '*' -> {
                result = a * b;
                logger.info("Выполненная операция: умножение. " + a + "* " + b + " Результат: " + result);
            }
            case '/' -> {
                if (b == 0) {
                    logger.warning("На ноль делить нельзя!!!");
                    throw new ArithmeticException("На ноль делить нельзя!!!");
                }

                result = (double) a / b;
                logger.info("Выполненная операция: деление. " + a + "/ " + b + " Результат: " + result);
            }
            default -> {
                logger.log(Level.WARNING, "Ошибка! Некорректная операция.");
                throw new IllegalArgumentException("Ошибка! Некорректная операция.");
            }
        }
        return result;
    }
}




