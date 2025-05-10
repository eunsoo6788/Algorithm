package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15918 {

    /**
     * 랭퍼든 수열쟁이야
     * 백트래킹
     * 골드5
     */

    private static int n;
    private static int x;
    private static int y;
    private static int count = 0;
    private static int[] arr;
    private static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());


        int value = y-x-1;

        arr = new int[2*n];
        visited = new int[n+1];

        visited[value] = 2;
        arr[x-1] = value;
        arr[y-1] = value;

        solve(0);

        System.out.println(count);

    }


    private static void solve(int depth) {

        if (depth == n) {
            count++;
            return;
        }

        if (depth == x-1 || depth == y-1) {
            solve(depth+1);
        }

        for (int i = 1; i <= n; i++) {

            if (visited[i] < 1) {

                if (depth+i+1 >= 2*n || depth == x-1 || depth == y-1) {
                    continue;
                }

                if (arr[depth] != 0 || arr[depth+i+1] !=0) {
                    continue;
                }

                visited[i]++;
                arr[depth] = i;
                arr[depth+i+1] = i;



                solve(depth+1);
                visited[i]--;
            }

        }


    }


}
