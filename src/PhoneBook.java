import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] book = new String[1000][2];
        int count = 0;

        while (true) {
            boolean isCorrectName = false;
            boolean isCorrectNumber = false;
            boolean isExist = false;
            //цикл ввода имени
            while (!isCorrectName) {
                System.out.println("Введите ФИО");
                String name = scanner.nextLine(); //Считывает строку из System.in
                if (name =="list"){
                    list(book);
                    break;
                }
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
                                add(book, name, phoneNumber, count);
                                System.out.println("запись добавлена: " + book[count][0] +" " + book[count][1]);
                                list(book);
                                count++;
                            }
                        }
                    }
                } else {//если имя найдено
                    System.out.println("Абонент уже есть в базе. Его телефон:" + findPhoneByName(book, name));
                }
            }
        }

    }

    private static String findPhoneByName(String[][] book, String name) { //поиск номера в базе по имени (первое вхождение)
        String number = "";
        for (int i = 0; i < book.length; i++) {
            if (book[i][0] == name) {
                number = book[i][1];
                break;
            }
        }
        return number;
    }

    private static boolean existName(String[][] book, String name) { // проверка наличия имени в базе
        for (int i = 0; i < book.length; i++) {
            if (book[i][0] == name) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNumber(String phoneNumber) { //проверка номера на корректность
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public static boolean checkName(String[][] book, String name) { //проверка имени на корректность
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

    public static void add(String[][] book, String name, String phoneNumber, int count) { //добавление записи в базу
        book[count][0] = name;
        book[count][1] = phoneNumber;
    }

    public static void list(String[][] book) { //вывод базы телефонов
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i][0].substring(book[i][1].indexOf(" ") + 1, book[i][0].lastIndexOf(" ") - 1) + ":" + book[i][1]);
        }
    }

    private static String formatNumber(String phoneNumber) { //форматирование телефонного номера
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);

        return result;
    }
}
