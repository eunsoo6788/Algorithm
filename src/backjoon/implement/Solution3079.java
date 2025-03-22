package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution3079 {

    /**
     * 입국심사
     * 이분탐색
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int immediate = Integer.parseInt(st.nextToken());
        int person = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[immediate];


        for (int i = 0; i < immediate; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);


        int left = 0;
        int right = person * max;
        int answer = Integer.MAX_VALUE;

        while (left <= right) {

            int mid = (left + right) / 2;

            int count = 0;

            for (int time : arr) {
                count += mid / time;
            }

            if (count >= person) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }


        }

        System.out.println(answer);

    }


}
