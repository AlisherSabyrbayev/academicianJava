public class Example {
    public static void main(String[] args) {
        print(6);
    }

    public static void print(int n) {
        if (n < 1)
            return;
        print(n - 1);
        System.out.println(n + " ");
    }
}
 