import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


public class P5 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num = Integer.parseInt(s.nextLine());

        ArrayList<String> letters = new ArrayList<String>();
        int[] possible = {0,1};
        ArrayList<String> equations = new ArrayList<String>();

        for(int i = 0; i < num; i++) {

            String str = s.nextLine();
            equations.add(str);
            String[] words = str.split(" ");

            if(words.length == 3) {
                if(!letters.contains(words[0])) {
                    letters.add(words[0]);
                }
                if(!letters.contains(words[2])) {
                    letters.add(words[2]);
                }

            } else if (words.length == 4) {
                if(!letters.contains(words[0])) {
                    letters.add(words[0]);
                }
                if(!letters.contains(words[3])) {
                    letters.add(words[3]);
                }

            } else if (words.length == 5) {
                if(!letters.contains(words[1])) {
                    letters.add(words[1]);
                }
                if(!letters.contains(words[4])) {
                    letters.add(words[4]);
                }
            }
        }

        ArrayList<int[]> combo = probabilityPermutation(letters.size());

        int correctCombo = -1;

        for(int i = 0; i < combo.size(); i++) {

            int[] corr = combo.get(i);
            boolean pass = true;

            for(int j = 0; j < equations.size(); j++) {

                String line = equations.get(j);
                String[] split = line.split(" ");

                if(split.length == 3) {
                    String let1 = split[0];
                    String let2 = split[2];

                    int cor1 = corr[(letters.indexOf(let1))];
                    int cor2 = corr[(letters.indexOf(let2))];

                    boolean one = false;
                    boolean two = false;

                    if(cor1 == 1) {
                        one = true;
                    }
                    if(cor2 == 1) {
                        two = true;
                    }

                    boolean value = one && two;

                    if(value) {
                        j = equations.size();
                        pass = false;
                    }


                } else if (split.length == 4) {

                    String let1 = split[0];
                    String let2 = split[3];

                    int cor1 = corr[(letters.indexOf(let1))];
                    int cor2 = corr[(letters.indexOf(let2))];

                    boolean one = false;
                    boolean two = false;

                    if(cor1 == 1) {
                        one = true;
                    }
                    if(cor2 == 1) {
                        two = true;
                    }

                    boolean value = one && (!two);

                    if(value) {
                        j = equations.size();
                        pass = false;
                    }

                } else if (split.length == 5) {

                    String let1 = split[1];
                    String let2 = split[4];

                    int cor1 = corr[(letters.indexOf(let1))];
                    int cor2 = corr[(letters.indexOf(let2))];

                    boolean one = false;
                    boolean two = false;

                    if(cor1 == 1) {
                        one = true;
                    }
                    if(cor2 == 1) {
                        two = true;
                    }

                    boolean value = (!one) && (!two);

                    if(value) {
                        j = equations.size();
                        pass = false;
                    }

                }



            }

            if (pass) {
                correctCombo = i;
                i = combo.size();
            }





        }

        String output = "";

        if (correctCombo < 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            int[] right =  combo.get(correctCombo);

            for(int i = 0; i < right.length; i++) {
                int bit = right[i];

                if(bit == 1) {
                    output += letters.get(i);
                }

            }

            System.out.println(output);
        }




    }




    public static ArrayList<int[]> probabilityPermutation(int len) {

        ArrayList<int[]> combo = new ArrayList<int[]>();

        int num = len;
        int[] arr = new int[num];

        for(int i = 0; i < Math.pow(2, num); i++) {

            String number = Integer.toBinaryString(i);

            int counter = num - 1;

            for(int j = number.length() - 1; j >= 0; j--) {
                arr[counter] = Integer.parseInt(number.charAt(j) + "");
                counter--;
            }

            combo.add(arr);
            arr = new int[num];

        }

        return combo;
    }


}
