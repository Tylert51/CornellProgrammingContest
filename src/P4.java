import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class P4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        ArrayList<Integer> corr = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<String> nums = new ArrayList<String>();
        permute("0123456789", "", nums);



        String num1 = line.substring(0, line.indexOf("+"));
        String num2 = line.substring(line.indexOf("+") + 1, line.indexOf("="));
        String result = line.substring(line.indexOf("=") + 1);

        for(int i = 0; i < nums.size(); i++) {
            String perm = nums.get(i);

            String[] digits1 = num1.split("");
            String[] digits2 = num2.split("");
            String[] digits3 = result.split("");

            int val1 = 0;
            int val2 = 0;
            int val3 = 0;

            for(int j = 0; j < digits1.length; j++) {
                digits1[j] = perm.charAt(Integer.parseInt(digits1[j])) + "";
            }
            for(int j = 0; j < digits2.length; j++) {
                digits2[j] = perm.charAt(Integer.parseInt(digits2[j])) + "";
            }
            for(int j = 0; j < digits3.length; j++) {
                digits3[j] = perm.charAt(Integer.parseInt(digits3[j])) + "";
            }
            String str = "";
            for (String strq : digits1)
            {
                str += strq;
            }
            val1 = Integer.parseInt(str);

            str = "";
            for (String strq : digits2)
            {
                str += strq;
            }
            val2 = Integer.parseInt(str);

            str = "";
            for (String strq : digits3)
            {
                str += strq;
            }
            val3 = Integer.parseInt(str);

            if (val1 + val2 == val3)
            {
                System.out.println(perm);
                i = nums.size();

            }
        }


    }

    public static void permute(String str, String ans, ArrayList<String> answers)
    {

        // If string is empty
        if (str.length() == 0) {
            answers.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            String letter = str.charAt(i) + "";

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            permute(ros, ans + letter, answers);

        }

    }
}
