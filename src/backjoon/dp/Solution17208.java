package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution17208 {

    /**
     * 카우버거 알바생
     * 골드4
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num = Integer.parseInt(st.nextToken());
        int cheeseNum = Integer.parseInt(st.nextToken());
        int friedNum = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] cheeseDp = new int[cheeseNum+1];
        int[] friedDp = new int[friedNum+1];


        for (int i = 0; i < num; i++) {

            int cheese = arr[i][0];
            int fried = arr[i][1];

            for (int j = cheeseNum; j >= cheese; j--) {


                for (int k = friedNum; k >= fried; k--) {

                }

            }




        }


    }


}
