package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution7490 {

    /**
     * 링크와 스타트
     * 백트래킹
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());


        for (int test = 0; test < caseNum; test++) {

            int num = Integer.parseInt(br.readLine());

            backTracking(num, 2, 1, 1, "1");
            System.out.println();
        }

    }


    private static void backTracking(int num, int depth, int sum, int before, String str) {

        if (depth == num + 1) {

            if (sum == 0) {
                System.out.println(str);
            }


            return;
        }


        backTracking(num, depth + 1, before > 0 ? sum - before + (before * 10 + depth) : sum + (before*-1) + (before * 10 - depth), before > 0 ? before * 10 + depth : (before * 10 - depth), str + " " + depth);
        backTracking(num, depth + 1, sum + depth, depth, str + "+" + depth);
        backTracking(num, depth + 1, sum - depth, depth * -1, str + "-" + depth);


    }


}
