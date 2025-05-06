package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2504 {

    /**
     * 항체인식
     * 골드5
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(' || c =='[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {

                if (stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                    stack.push('2');
                } else if (stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    stack.pop();
                    stack.push('3');
                }
            }


        }



    }



}
