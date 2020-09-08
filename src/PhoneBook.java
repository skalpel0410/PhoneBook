import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] book = new String[1][2];
        boolean isCorrectName = false;
        boolean isCorrectNumber = false;
        boolean isExist = false;
        String input = scanner.nextLine();
        while (!input.toLowerCase().equals("exit")) {
            isCorrectName = false;
            isCorrectNumber = false;
            isExist = false;
            //цикл ввода имени
            while (!isCorrectName) {
                System.out.println("Введите ФИО");
                String name = scanner.nextLine(); //Считывает строку из System.in
                isCorrectName = checkName(book, name);
                isExist = existName(book, formatName(name));
                if (!isExist) {//если имя не найдено
                    if (!isCorrectName) {//если имя некорректно
                        System.out.println("Введите корректное имя!");
                    } else {
                        //если имя корректно
                        name = (formatName(name));
                        //ввод номера
                        while (!isCorrectNumber) {
                            System.out.println("Введите номер телефона");
                            String phoneNumber = scanner.nextLine(); //Считывает строку из System.in
                            isCorrectNumber = checkPhoneNumber(phoneNumber);
                            if (!isCorrectNumber) {
                                //если номер некорректен
                                System.out.println("Введите корректный номер!");
                            } else {
                                phoneNumber = formatNumber(phoneNumber);
                                add(book, name, phoneNumber);
                                System.out.println("запись добавлена: " + book[book.length - 1][0] + " " + book[book.length - 1][1]);
                                list(book);
                                book = Arrays.copyOf(book, book.length + 1);
                                book[book.length - 1] = new String[2];
                            }
                        }
                    }
                } else {//если имя найдено
                    System.out.println("Абонент уже есть в базе. Его телефон:" + findPhoneByName(book, formatName(name)));
                }
            }
        }

    }

    private static String findPhoneByName(String[][] book, String name) { //поиск номера в базе по имени (первое вхождение)
        String number = "";
        for (int i = 0; i < book.length; i++) {
            if (name.equals(book[i][0])) {
                number = book[i][1];
                break;
            }
        }
        return number;
    }

    private static boolean existName(String[][] book, String name) { // проверка наличия имени в базе
        for (int i = 0; i < book.length; i++) {
            if (name.equals(book[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNumber(String phoneNumber) { //проверка номера на корректность
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public static boolean checkName(String name) { //проверка имени на корректность
        String[] words = name.trim().split(" ");
        return words.length == 3;
    }

    public static String formatName(String name) { //форматирование имени
        String[] words = name.trim().split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                result += Character.toUpperCase(firstChar) + str.substring(1) + " ";
            } else {
                result += str + " ";
            }
        }
        return result;
    }

    public static void add(String[][] book, String name, String phoneNumber) { //добавление записи в базу
        book[book.length - 1][0] = name;
        book[book.length - 1][1] = phoneNumber;
    }

    public static void list(String[][] book) { //вывод базы телефонов
        String[] flat = new String[book.length];
        for (int i = 0; i < book.length; i++) {
            flat[i] = book[i][0] + ": " + book[i][1];
        }
        Arrays.sort(flat);
        for (int i = 0; i < flat.length; i++) {
            System.out.println(flat[i]);
        }
    }

    private static String formatNumber(String phoneNumber) { //форматирование телефонного номера
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
    }
}
