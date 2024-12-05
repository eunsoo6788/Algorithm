package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution4889 {

    public static void main(String[] args) throws IOException {

        /**
         * 안정적인 문자열 4889
         * 자료구조
         * 실버 1
         * sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index  = 1;
        while (true) {

            String str = br.readLine();

            if (str.contains("-")) {
                break;
            }


            Stack<Character> stack = new Stack<>();

            for (int i = 0 ; i < str.length() ; i++) {
                if (!stack.isEmpty() && stack.peek() == '{' && str.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.add(str.charAt(i));
                }
            }


            int leftCount = 0;
            int rightCount = 0;

            for (char i : stack) {
                if (i == '{') {
                    leftCount++;
                } else {
                    rightCount++;
                }
            }



            if (leftCount == 1 && rightCount == 1){
                System.out.println(index +". " + 2);
            } else {
                int answer = 0;
                answer += (leftCount + 1)/2;
                answer += (rightCount + 1)/2;

                System.out.println(index +". " +answer);

            }

            index++;




        }



    }


}
