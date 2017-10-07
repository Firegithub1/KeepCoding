public class Book1 {
    private static int counter = 0;

    public Book1(String title) {
        System.out.println("售出图书：" + title);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
