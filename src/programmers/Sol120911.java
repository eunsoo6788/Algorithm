package programmers;

import java.util.Arrays;

public class Sol120911 {
    public String solution(String my_string) {

        my_string = my_string.toLowerCase();
        String[] arr = my_string.split("");
        Arrays.sort(arr);

        String answer = "";

        for (String s : arr) {
            answer += s;
        }


        return answer;
    }


    public static void main(String[] args) {
        Sol120911 sol = new Sol120911();
        String my_string = "Bcad";
        System.out.println(sol.solution(my_string));
    }
}
