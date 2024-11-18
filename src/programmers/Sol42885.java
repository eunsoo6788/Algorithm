package programmers;

import java.util.Arrays;

public class Sol42885 {

    public String solution(String number, int k) {
        String answer = "";

        int[] arr = new int[number.length()];

        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
        }

        Arrays.sort(arr);

        String beforeStr = "";
        int count = 0;
        for (int i = 0 ; i < number.length(); i++) {

            if (count == k){
                beforeStr += number.charAt(i);
            }
            else if (arr[count] != number.charAt(i) - '0') {
                beforeStr += number.charAt(i);
            } else {
                count++;
            }
        }




        return beforeStr;
    }


    public static void main(String[] args) {
        Sol42885 sol = new Sol42885();
        String number = "1231234";
        int k = 3;
        System.out.println(sol.solution(number, k));
    }
}
