package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1038 {

    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 10 ; i < 1_000_001 ; i++) {

            dfs(i, 0);

            if (answer == num) {
                System.out.println(i);
                return;
            }

        }

    }

    private static void dfs(int num, int count) {

        if (num / 10 == 0) {
            if (num % 10 > count) {
                answer++;
            }
            return;
        }

        if (num % 10 < count) {
            return;
        }

        int namoge = num%10;


        dfs(num/10,namoge);


    }


}
