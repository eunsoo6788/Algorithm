package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1205 {

    /**
     * 등수 구하기
     * 구현
     * 실버4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int low = lowerBound(arr,score);
        int up = upperBound(arr,score);

        System.out.println();


    }


    private static int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }


    private static int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }





}
