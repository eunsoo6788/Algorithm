package programmers;

import java.util.Arrays;

public class Solution42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i = 0 ; i < commands.length ; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] arr = new int[end - start + 1];
            for (int j = start ; j <= end ; j++) {
                arr[j - start] = array[j - 1];
            }

            Arrays.sort(arr);
            answer[i] = arr[k - 1];
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution42748 sol = new Solution42748();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }
}
