
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1182 {

    /**
     * 부분수열의 합
     * 실버2
     * 백트래킹
     */


    private static boolean[] visited;
    private static int[] arr;
    private static int num;
    private static int target;
    private static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[num];
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        backtracking(0,0, -1);

        System.out.println(count);

    }


    private static void backtracking(int depth, int sum, int beforeIndex) {

        if (depth > 0 && sum == target) {
            count++;
        }

        if (depth == num) {
            return;
        }


        for (int i = beforeIndex+1 ; i < num ; i++) {

            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth +1, sum + arr[i], i);
                visited[i] = false;
            }

        }


    }


}
