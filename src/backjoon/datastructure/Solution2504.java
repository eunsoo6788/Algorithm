package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2504 {

    public static void main(String[] args) throws IOException {

        /**
         * 괄호의 값 2504
         * 자료구조
         * 골드 5
         * not sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        Stack<Character> stack = new Stack<>();
        Stack<Character> number = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (stack.isEmpty()) {
                stack.add(str.charAt(i));
                continue;
            }


            if (str.charAt(i) == ']' || str.charAt(i) == ')') {

                while (!stack.isEmpty() && stack.peek() >= 0 && stack.peek() <= 9) {
                    number.push(stack.pop());
                }

                if (!stack.isEmpty() && (stack.peek() == '[' && str.charAt(i) == ']') || (stack.peek() == '(' && str.charAt(i) == ')') ) {

                    if (number.isEmpty()) {
                        if (str.charAt(i) == ']') {
                            stack.pop();
                            stack.push('2');
                        } else {
                            stack.pop();
                            stack.push('3');
                        }
                    } else {

                        int num = 0;
                        int value = 1;

                        for (Character c : number) {
                            num += (c - '0') * value;
                            value *= 10;
                        }

                        number.clear();

                        if (str.charAt(i) == ']') {
                            stack.pop();
                            num *= 2;

                            String tmp = String.valueOf(num);

                            for (int k = 0; k < tmp.length(); k++) {
                                number.push(tmp.charAt(k));
                            }

                        } else {
                            stack.pop();
                            num *= 3;

                            String tmp = String.valueOf(num);

                            for (int k = 0; k < tmp.length(); k++) {
                                number.push(tmp.charAt(k));
                            }
                        }


                    }

                } else {

                    while (!number.isEmpty()) {
                        stack.push(number.pop());
                    }

                    stack.push(str.charAt(i));

                }

            } else {
                stack.push(str.charAt(i));
            }


        }


        System.out.println();





    }
}
