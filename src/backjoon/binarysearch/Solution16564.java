package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16564 {

    /**
     * 접두사 찾기
     * 실버1
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        long point = Integer.parseInt(st.nextToken());


        long[] arr = new long[num];
        long min = Integer.MAX_VALUE;
        long max = 0;


        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }


        long low = min;
        long high = max + point;

        while (low <= high) {

            long mid = (low + high) / 2;

            long score = 0;
            for (int i = 0; i < num; i++) {
                if (arr[i] < mid) {
                    score += Math.abs(arr[i] - mid);
                }
            }

            if (score < point) {
                low = mid + 1;
            } else if (score > point) {
                high = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }


        System.out.println(high);



    }

}
