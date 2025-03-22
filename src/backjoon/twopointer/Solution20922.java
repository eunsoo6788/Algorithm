package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution20922 {

    /**
     * 겹치는 건 싫어
     * 투 포인터
     * not sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int success = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Map<Integer, Integer> map = new HashMap<>();

        int length = 0;

        int left = 0;
        int right = 0;
        while (right < num) {



            while (right < num && map.getOrDefault(arr[right], 0) < success) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                length = Math.max(length, right - left+1);
                right++;
            }

            if (right == num) {
                break;
            }

            while (left < right  && arr[left] != arr[right]) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                left++;
            }

            map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
            left++;

        }




        System.out.println(length);


    }
}
