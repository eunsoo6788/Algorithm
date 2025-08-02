package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12915 {

    /**
     * 대회개최
     * 골드5
     * 알고리즘 : 이분탐색
     */

    private static int low;
    private static int lowAndMid;
    private static int mid;
    private static int midAndHigh;
    private static int high;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        low = Integer.parseInt(st.nextToken());
        lowAndMid = Integer.parseInt(st.nextToken());
        mid = Integer.parseInt(st.nextToken());
        midAndHigh = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());


        int left = 0;
        int right = 200_000;


        while (left <= right) {
            int middle = (left + right) / 2;


            if (isPossible(middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(right);


    }

    private static boolean isPossible(int target) {

        int one = low - target;
        int two = lowAndMid;
        int three = mid - target;
        int four = midAndHigh;
        int five = high - target;

        if (one < 0) {
            two += one;
        }

        if (five < 0) {
            four += five;
        }

        if (two >= 0 && four >= 0) {
            if (three + two + four >= 0) {
                return true;
            }
        }

        return false;
    }

}
