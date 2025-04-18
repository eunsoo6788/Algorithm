package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution14889Re {

    /**
     * 스타트와 링크
     * 실버1
     * 백트래킹
     */

    private static int[][] map;
    private static boolean[] visited;
    private static int size;
    private static int min;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size];

        min = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);


    }

    private static void dfs(int depth, int index) {

        if (depth == size/2) {

            int[] a = new int[size/2];
            int[] b = new int[size/2];

            int indexA = 0;
            int indexB = 0;
            for (int i = 0; i < size; i++) {
                if (visited[i]) {
                    a[indexA] = i;
                    indexA++;
                } else {
                    b[indexB] = i;
                    indexB++;
                }
            }

            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < size/2 -1; i++) {
                for (int j = i+1; j < size/2; j++) {
                    sumA += map[a[i]][a[j]];
                    sumA += map[a[j]][a[i]];
                    sumB += map[b[i]][b[j]];
                    sumB += map[b[j]][b[i]];
                }
            }

            min = Math.min(min, Math.abs(sumA - sumB));

            return;
        }

        for (int i = index; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i);
                visited[i] = false;
            }
        }



    }





}
