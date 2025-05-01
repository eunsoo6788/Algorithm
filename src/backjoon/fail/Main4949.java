package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {

    /**
     * 균형잡힌 세상
     * 실버4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }


            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }


                if (c == ')') {

                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }

                    stack.push(')');
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    stack.push(']');
                }

            }


            if (!stack.isEmpty()) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }


        }





    }








}
