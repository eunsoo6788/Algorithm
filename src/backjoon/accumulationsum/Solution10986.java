package backjoon.accumulationsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10986 {

    /**
     * 나머지 합 10986
     * 알고리즘 : 구간합
     * not sol
     * 골드 3
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int[] sum = new int[num];
        int[] arr = new int[num];
        int count = 0;

        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

        sum[0] = Integer.parseInt(stArr.nextToken());
        for (int i = 1; i < num; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
            sum[i] += sum[i-1] + arr[i];
        }

        for (int i = 0; i < num; i++) {
            if (sum[i] % value == 0) {
                count++;
            }
        }

        for (int i = 0 ; i < num -1 ; i++) {
            for (int j =i+1; j < num; j++) {
                sum[j] -= arr[i];
                if (sum[j] % value == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
