package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1920 {

    /**
     * 수 찾기 1920
     * 이분탐색
     * 실버4
     * Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // 비교 되는 배열
        long[] arr = new long[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long max = arr[num-1];


        // 해당 값이 비교 되는 배열에 있는지 확인한는 문제 배열
        int problemNum = Integer.parseInt(br.readLine());
        long[] problemArr = new long[problemNum];
        int[] answer = new int[problemNum];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < problemNum; i++) {
            problemArr[i] = Integer.parseInt(st2.nextToken());
        }


        for (int i = 0 ; i < problemNum ; i++) {

            int low = 0;
            int high = num-1;

            while (low <= high) {

                int mid = (low + high) /2 ;

                if (arr[mid] > problemArr[i]) {
                    high = mid -1;
                } else if (arr[mid] < problemArr[i]) {
                    low = mid +1;
                } else {
                    answer[i] = 1;
                    break;
                }
            }

        }


        for (int i : answer) {
            System.out.println(i);
        }





    }

}
