package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution23758 {


    /**
     * 중앙값 제거
     * 실버 1
     * 알고리즘 : 그리디
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int index = (n+1)/2 - 1;

        int count = 0;
        while (true) {

            arr[index] = arr[index] / 2;
            count++;

            if (arr[index] == 0) {
                break;
            }
            Arrays.sort(arr);

        }

        System.out.println(count);




    }

}
