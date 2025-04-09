
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15685 {

    /**
     * 연산자 끼워넣기 (2)
     * 실버2
     * 백트래킹
     */


    private static boolean[] visited;
    private static int[] arr;
    private static int[] operator;
    private static int num;
    private static int max = Integer.MIN_VALUE;;
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());


        arr = new int[num];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);

        System.out.println(max);
        System.out.println(min);

    }


    private static void backtracking(int depth, int sum) {

        if (depth == num) {

            max = Math.max(sum, max);
            min = Math.min(sum, min);

            return;
        }


        for (int i = 0; i < 4; i++) {

            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth]);
                }


                operator[i]++;

            }


        }


    }


}
