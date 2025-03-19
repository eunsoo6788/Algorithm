package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1174 {

    /**
     * 줄어드는수
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int target = Integer.parseInt(br.readLine());




        for (int i = 0; i <= 1_000_000; i++) {
            solve(i,-1);

            if (answer == target) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);


    }


    private static void solve(int n, int namoge) {

        if (n%10 <= namoge) {
            return;
        }


        if (n / 10 == 0) {

            if (n > namoge) {
                answer++;
            }

            return;
        }


        solve(n/10, n%10);

    }

}
