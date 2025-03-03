package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2110 {

    /**
     * 공유기 설치 2110
     * 알고리즘 : 이분탐색
     * 골드 4
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String value = br.readLine();


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == value.charAt(0)) {
                if (i <= str.length() - value.length()) {
                    if (str.substring(i, i + value.length()).equals(value)) {
                        str = str.substring(0, i) + str.substring(i + value.length());
                        i--;
                        continue;
                    }
                }
            }

            stack.push(c);
        }

        for (char c : stack) {
            System.out.print(c);
        }




    }

}
