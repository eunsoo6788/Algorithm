package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12847Re {

    /**
     * 꿀 아르바이트 12847
     * 실버3
     * 알고리즘 : 슬라이딩 윈도우
     * Sol -> long 주의
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        long moneySum = 0;
        int[] arr = new int[num];

        for (int i = 0 ; i < num ; i++ ) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        long answer = 0;
        for (int i = 0 ; i < num ; i++ ) {
            if (i < size) {
                moneySum += arr[i];
                answer = Math.max(answer, moneySum);
            } else {
                moneySum += arr[i];
                moneySum -= arr[i-size];
                answer = Math.max(answer, moneySum);
            }
        }


        System.out.println(answer);



    }



}
