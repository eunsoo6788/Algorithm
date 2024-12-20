package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2018 {

    /**
     * 백준 : 수들의 합 2018
     * 알고리즘 : 투 포인터
     * sol -> 풀긴했는데 조금 애매한 느낌. 다음에 한번 더 풀어보면 좋을듯.
     * 실버5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        long low = 1;
        long high = 1;
        long sum = 1;
        int count = 0;

        while (low <= high) {

            if (sum < num) {
                high++;
                sum += high;
            }  else {
                if (sum == num) {
                    count++;
                }
                sum -= low;
                low++;
            }


        }

        System.out.println(count);


    }
}
