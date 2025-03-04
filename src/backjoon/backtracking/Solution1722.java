package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1722 {

    /**
     * 1722 순열의 순서
     * 골드5
     * 알고리즘 : 백트래킹?
     * Not Sol
     */

    private static int n;
    private static int[] tmp;
    private static int[] arr;
    private static boolean[] visited;
    private static int count = 0;
    private static int countTwo = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        tmp = new int[n];
        visited = new boolean[n];
        int problem = Integer.parseInt(st.nextToken());

        if (problem == 1) {
            int index = Integer.parseInt(st.nextToken());

            solveTwo(0, index);
        } else {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solveOne(0);


        }

    }

    private static void solveTwo(int depth, int index) {

        if (depth == n) {
            count++;

            if (count == index) {

                for (int i : tmp) {
                    System.out.print(i + " ");
                }
                System.out.println();
                return;
            }

        }

        for (int i = 1 ; i <= n ; i++) {
            if (!visited[i-1]) {
                visited[i-1] = true;
                tmp[depth] = i;
                solveTwo(depth + 1, index);
                visited[i-1] = false;
            }

        }
    }


    private static void solveOne(int depth) {

        if (depth == n) {
            countTwo++;

            boolean isSame = true;
            for (int i = 0 ; i < n ; i++) {
                if (tmp[i] != arr[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                System.out.println(countTwo);
                flag = true;
                return;
            }

        }

        for (int i = 1 ; i <= n ; i++) {
            if (flag) {
                break;
            }
            if (!visited[i-1]) {
                visited[i-1] = true;
                tmp[depth] = i;
                solveOne(depth + 1);
                visited[i-1] = false;
            }

        }
    }


}
