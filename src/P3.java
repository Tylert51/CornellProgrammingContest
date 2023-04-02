import java.util.Objects;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String line = s.nextLine();

        String[] words = line.split(" ");

        for(int i = 0; i < words.length; i++) {

            if(Objects.equals(words[i], "is")) {
                words[i] = "isnt";
            } else if (Objects.equals(words[i], "isnt")) {
                words[i] = "is";
            }

        }

        String str = "";

        for(int i = 0; i < words.length - 1; i++) {
            str += words[i] + " ";
        }

        str += words[words.length - 1];

        System.out.println(str);

    }
}
