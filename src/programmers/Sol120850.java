package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol120850 {
    public int[] solution(String my_string) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < my_string.length() ; i++) {

            if (my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                list.add(my_string.charAt(i) - '0');
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            arr[i] = list.get(i);
        }

        Arrays.sort(arr);

        return arr;
    }


    public static void main(String[] args) {
        Sol120850 sol = new Sol120850();
        String my_string = "hi12392";
        System.out.println(sol.solution(my_string));
    }
}
