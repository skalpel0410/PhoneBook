import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] book = new String[1000][2];
        boolean isCorrectName = false;
        while (true) {
            //цикл ввода имени
            while (!isCorrectName) {
                String name = scanner.nextLine(); //Считывает строку из System.in
                isCorrectName = checkName(name);
                if (!isCorrectName) {
                    System.out.println("Введите корректное имя!");
                } else {
                    name = (formatName(name));
                }
            }
            //цикл ввода телефона
        }
        //Добавить считывание ввода пользователя в цикле
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static String formatName(String name) {
        tring[] words = name.trim().split(" ");
        sortByLength(words);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                result += Character.toUpperCase(firstChar) + str.substring(1) + " ";
            } else {
                result += str + "";
            }
        }
        return result;
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i][0].substring(book[i][1].indexOf(" ")+1,book[i][0].lastIndexOf(" ")-1) + ":" + book[i][1]);
        }
    }
}
