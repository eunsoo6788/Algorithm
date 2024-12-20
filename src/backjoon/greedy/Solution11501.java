package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution11501 {

    /**
     * 백준 : 주식
     * 알고리즘 : 그리디
     * not sol
     * 실버2
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0 ; test < testCase ; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            int[] sortArr = new int[num];

            StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < num ; i++) {
                arr[i] = Integer.parseInt(stArr.nextToken());
                sortArr[i] = arr[i];
            }
            int sortArrIndex = num-1;
            int buyStartIndex = 0;

            Arrays.sort(sortArr);

            long sum = 0;

            for (int i = 0 ; i < num ; i++ ) {

                // 판매
                if (arr[i] == sortArr[sortArrIndex]) {

                    for (int j = buyStartIndex ; j < i ; j++) {
                        sum += arr[i] - arr[j];
                    }

                    buyStartIndex = i + 1;
                    sortArrIndex--;

                }
            }

            System.out.println(sum);


        }






    }

}
