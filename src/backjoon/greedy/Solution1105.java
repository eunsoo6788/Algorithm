package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1105 {


    /**
     * 팔 1105
     * 실버1
     * 알고리즘 : 그리디
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Integer.parseInt(st.nextToken());
        long r = Integer.parseInt(st.nextToken());


        long min = Long.MAX_VALUE;
        for (long i = l; i <= r; i++) {
            min = Math.min(min, solve(i));

            if (min == 0) {
                break;
            }
        }

        System.out.println(min);

    }

    private static int solve(long num) {

        int count = 0;

        while (num / 10 > 0) {
            if (num % 10 == 8) {
                count++;
            }

            num = num / 10;
        }

        if (num % 10 == 8) {
            count++;
        }

        return count;
    }

}
