package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution17503 {

    /**
     * 백준 : 맥주 축제 17503
     * 알고리즘 : 이분탐색
     * not sol
     * 실버1
     */

    private static int[][] list;
    private static int num;
    private static int favorite;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        favorite = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        long low = 0;
        long high = 0;


        int[][] arr = new int[size][2];

        for (int i = 0; i < size; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st1.nextToken());

            high = Math.max(high, arr[i][1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[1];
        });


        while (low <= high) {
            boolean[] visited = new boolean[size];
            count = 0;

            long mid = (high + low) / 2;

            list = new int[size][num];


        }

    }

    private void dfs(int[][] arr, boolean[] visited, int depth, int[] selected) {

        if (depth == num) {
            int sum = 0;

            for (int i : selected) {
                sum += i;
            }

            if (sum >= favorite) {

                for (int i = 0; i < num; i++) {
                    list[count][i] = selected[i];
                }
                count++;
            }


            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                dfs(arr, visited, depth + 1, selected);
                visited[i] = false;

            }

        }

    }


}
