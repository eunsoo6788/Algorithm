package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution11000 {

    /**
     * 백준 : 강의실 배정
     * 알고리즘 : 그리디
     * sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];

        for ( int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int answer = 0;
        for (int i = 0 ; i < num ; i++) {
            int count = 1;
            for (int j = i-1 ; j>=0 ; j--) {
                if (arr[i][0] < arr[j][1]) {
                    count++;
                }
            }

            answer = Math.max(answer,count);
        }

        System.out.println(answer);

    }


}
