package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11497 {

    /**
     * 백준 : 통나무 건너뛰기
     * 알고리즘 : 투 포인터
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = num-1;

        int count = 0;
        while (left <= right) {

            for (int i = right ; i > left ; i--) {
                if (arr[left] + arr[i] == target ){
                    count++;
                    break;
                }
            }

            left++;
        }


        System.out.println(count);


    }
}
