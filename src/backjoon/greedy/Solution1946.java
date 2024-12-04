package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1946 {

    /**
     * 백준 : 신입 사원
     * 알고리즘 : 그리디
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int caseNum = 0 ; caseNum < testCase ; caseNum++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0 ;

            int[][] arr = new int[num][2];
            for (int i = 0 ; i < num ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1,o2) -> {
                return o1[0] - o2[0];
            });

            int minScore = Integer.MAX_VALUE;
            for (int i = 0 ; i < num ; i++ ) {

                if (arr[i][1] < minScore) {
                    minScore = Math.min(minScore,arr[i][1]);
                    count++;
                }
            }

            System.out.println(count);
        }





    }





}
