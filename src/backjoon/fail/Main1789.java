package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1789 {

    /**
     * 랜선 자르기
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());


        for (long i = 1; i <= num; i++) {
            long value = solve(i);

            if (value == num) {
                System.out.println(i);
                break;
            } else if (value > num) {
                System.out.println(i-1);
                break;
            }


        }


    }

    private static long solve(long index) {

        long sum = 0;

        sum = (1+index) * (index/2);

        if (index % 2 == 1) {
            sum += (index/2 + 1);
        }

        return sum;
    }


}
