package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution6198 {

    /**
     * 탑 2493
     * 자료구조 - 스택
     * 골드5
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];
        for (int i = 0; i< num ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(arr[num-1]);

        for (int i = num-2 ; i >=0 ;i--) {
            if (stack.peek() <= arr[i]) {
                if (dp[i+1] == 0) {
                    dp[i] = stack.size();
                } else {
                    dp[i] = dp[i+1] +1;
                }
                stack.clear();
                stack.add(arr[i]);
            } else {
                stack.clear();
                stack.add(arr[i]);
            }

        }


        System.out.println();



    }


}
