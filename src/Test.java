import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        String [][] book = new String[1][2];
        String name = "иван иван иван";
        String phone = "+77472603250";
        book[0][0] = name;
        book[0][1] = phone;
        list(book);
        book = Arrays.copyOf(book, book.length+1);

        book[1] = new String[2];
        System.out.println("новый массив");
        book[1][0] = name;
        book[1][1] = phone;
        list(book);
    }
    public static void list(String[][] book) { //вывод базы телефонов
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i][0] + ": " + book[i][1]);
        }
    }
}

