package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12847 {

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

        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        long sum = 0;
        long max = 0;
        for (int i = 0 ; i < size ; i++) {
            sum += arr[i];
        }
        max = sum;


        for (int i = 1 ; i < num - size +1 ; i++) {
            sum += arr[i+size-1];
            sum -= arr[i-1];
            max = Math.max(max, sum);
        }

        System.out.println(max);



    }



}
