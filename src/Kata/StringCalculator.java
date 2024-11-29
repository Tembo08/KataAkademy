package Kata;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);// Создаем объект сканер
        String inputText = scanner.nextLine();// В переменную inputText записываются данные со сканера
        inputText = inputText.replaceAll("\"", "");// Убираем кавычки


        String lengthString = print(inputText); // В переменную lengthString записывается строка после проверки длинны
        char action = getAction(inputText);// В переменную action сохраняется символ нашей операции
        // который возвращает метод getAction()
        String[] array = getString(lengthString);// В переменную array передается String массив
        // который возвращает нам метод getStrin
        String result = operation(action, array);// Результат метода operation записаваем в переменную result

        printInQuotes(result);
    }

    // Данный метод проверяет длинну строки
    public static String print(String string) throws Exception {
        if (string.length() > 20) {
            throw new Exception("Длинна строки не должна превышать 10 символов!");
        }
        return string;
    }

    // метод возвращает оператор и записывает в переменную action
    public static char getAction(String string) throws Exception {
        if (string.contains("+")) {
            return '+';
        } else if (string.contains("-")) {
            return '-';
        } else if (string.contains("*")) {
            return '*';
        } else if (string.contains("/")) {
            return '/';
        } else throw new Exception("Не корректно введен символ операции");

    }

    //     метод разделяет нашу строку по оператору и будет возвращать нам string массив
//    String[] array = getString(l);
    public static String[] getString(String string) {

        if (string.contains("+")) {
            String[] str = string.split("[+]");
            return str;
        } else if (string.contains("-")) {
            String[] str = string.split("[-]");
//            if (str.length == 3) {}
            return str;
        } else if (string.contains("*")) {
            String[] str = string.split("[*]");
            return str;
        } else if (string.contains("/")) {
            String[] str = string.split("[/]");
            return str;
        }
        return null;
    }

    // Этот метод производит вчисления с нашими строками
    public static String operation(char action, String[] array) throws Exception {
        String result = "";

        if (action == '+') {
            result = array[0] + array[1];
        } else if (action == '*') {
            int i = Integer.parseInt(array[1]);
            result = array[0].repeat(i);
            if (i == 0) {
                throw new Exception("Нельзя умножить на 0");
            }

        } else if (action == '/') {
            int divider = Integer.parseInt(array[1]);
            int length = array[0].length();
            int lenghtNew = length / divider;
            result = array[0].substring(0, lenghtNew);
            if (divider == 0) {
                throw new Exception("Нельзя делить на ноль");
            }

        } else if (action == '-') {
            if (array.length == 3) {
                System.out.println("\"" + array[0] + "-" + array[1] + "\"");
                System.exit(0);
            } else {
                int index = array[0].indexOf(array[1]);
                result = array[0].substring(0, index);
            }
        }


        return result;
    }

    static String text = "";

    static void printInQuotes(String result) {
        text = result;
        if (text.length() > 40) {
            String substring = text.substring(0, 40);
            System.out.println("\"" + substring + "\"" + "...");
        } else System.out.println("\"" + result + "\"");
    }

}

