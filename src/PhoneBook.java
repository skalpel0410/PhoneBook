public class PhoneBook {

    public static void main(String[] args) {
        String[][] book = new String[1000][2];

        //Добавить считывание ввода пользователя в цикле
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static String formatName(String name) {
        return "";
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
