package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15661ReRe {

    /**
     * 링크와 스타트
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int min = Integer.MAX_VALUE;
    private static int num;
    private static int size;
    private static int[][] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        visited = new boolean[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        if (num %2 ==1) {
            size = num / 2 +1;
        } else {
            size = num / 2;
        }


        // 백트랰킹
        backtracking(0,0);


        System.out.println(min);



    }

    private static void backtracking(int depth, int index) {

        if (depth == size) {

            int[] teamA = new int[size];
            int[] teamB = new int[num - size];

            int teamACount = 0;
            int teamBCount = 0;

            for (int i = 0; i < num; i++) {
                if (visited[i]) {
                    teamA[teamACount] = i;
                    teamACount++;
                } else {
                    teamB[teamBCount] = i;
                    teamBCount++;
                }
            }

            int teamASum = 0;
            int teamBSum = 0;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    teamASum += arr[teamA[i]][teamA[j]];
                    teamASum += arr[teamA[j]][teamA[i]];
                }
            }

            for (int i = 0; i < num- size; i++) {
                for (int j = i + 1; j < num- size; j++) {
                    teamBSum += arr[teamB[i]][teamB[j]];
                    teamBSum += arr[teamB[j]][teamB[i]];
                }
            }

            min = Math.min(min, Math.abs(teamASum - teamBSum));

            return;
        }


        for (int i = index + 1; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }

    }


}
