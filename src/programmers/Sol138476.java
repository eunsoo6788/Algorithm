package programmers;

import java.util.*;

public class Sol138476 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;


        Map<Integer, Integer> map = new HashMap<>();

        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int[] arr = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            arr[index] = map.get(key);
            index++;
        }

        Arrays.sort(arr);

        for (int i = arr.length -1 ; i >= 0 ; i--) {

            k -= arr[i];

            if (k <= 0) {
                answer = arr.length - i;
                break;
            }

        }




        return answer;
    }

    public static void main(String[] args) {
        Sol138476 sol = new Sol138476();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k, tangerine));
    }
}
