import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {

        System.out.println();
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if(a + b == c) {
            System.out.println("Try again, Bob");
        } else {
            System.out.println("Good job, Bob!");
        }


    }
}