package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            var str = st.nextToken();
            var result = solve(str);
            System.out.println(result);
        }
    }


    private static String solve (String str) {
        int strLength = str.length();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) == '(') {
                stack.add("(");
            } else {

                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.add(")");
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }



}
