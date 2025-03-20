package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15661Re {

    /**
     * 링크와 스타트
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int min = Integer.MAX_VALUE;
    private static int num;
    private static int[][] arr;
    private static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        visited = new int[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 백트랰킹
        backtracking(0, 0,0, 0);

        System.out.println(min);

    }


    private static void backtracking(int start , int depth, int countOne, int countTwo) {

        if (depth == num) {

            if (countTwo >= 2 && countOne >= 2) {


                int sum1 = 0;
                int sum2 = 0;

                List<Integer> listOne = new ArrayList<>();
                List<Integer> listTwo = new ArrayList<>();


                for (int i = 0; i < num; i++) {
                    if (visited[i] == 1) {
                        listOne.add(i);
                    } else if (visited[i] == 2) {
                        listTwo.add(i);
                    }
                }

                for (int i : listOne) {
                    System.out.print(i + " ");
                }
                System.out.println();


                for (int i : listTwo) {
                    System.out.print(i + " ");
                }
                System.out.println();
                System.out.println();


                min = Math.min(min, Math.abs(sum1 - sum2));
            }


            return;
        }


        for (int i = start; i < num; i++) {

            if (visited[i] == 0) {
                visited[i] = 1;
                backtracking(i + 1, depth+1,countOne + 1, countTwo);
                visited[i] = 2;
                backtracking(i + 1, depth+1, countOne, countTwo + 1);
                visited[i] = 0;
            }
        }


    }


}
