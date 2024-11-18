package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol28278 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            var number = st.nextToken();    // 나이

            switch (number) {
                case "1" : input(st.nextToken(), stack); break;
                case "2" : printPop(stack); break;
                case "3" : printCount(stack); break;
                case "4" : printExist(stack); break;
                case "5" : printPeak(stack); break;
                default: break;
            }

        }





    }

    private static void input(String value, Stack<Integer> stack) {
        stack.add(Integer.parseInt(value));
    }


    private static void printPop(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.pop());
        }
    }

    private static void printCount(Stack<Integer> stack) {
        System.out.println(stack.size());
    }


    private static void printExist(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


    private static void printPeak(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
        }
    }



}
