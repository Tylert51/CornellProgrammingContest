import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String code = "";

        int num = Integer.parseInt(s.nextLine());

        for(int i = 0; i < num; i++) {
            String str = s.nextLine();

            code += str.substring(0,1);
        }

        System.out.println(code);
    }
}
