package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1806 {

    /**
     * 부분합 1806
     * 알고리즘 : 투 포인터
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];

        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 5;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {

            if (sum < target && right < num -1) {
                right++;
                sum += arr[right];
            } else if (sum < target && right >= num -1) {
                sum -= arr[left];
                left++;
            }
            else if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }
}
