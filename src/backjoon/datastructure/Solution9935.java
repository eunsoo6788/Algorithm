package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution9935 {

    /**
     * 문자열 폭발 9935
     * 자료구조 - 스택
     * 실버2
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();


        Stack<Character> stack = new Stack<>();
        Stack<Character> trashStack = new Stack<>();
        for (int i = 0; i < start.length(); i++) {
            stack.push(start.charAt(i));
        }

        while (!stack.isEmpty()) {

            char now = stack.pop();

            if (now == end.charAt(end.length()-1) && stack.size() >= end.length()-1) {

                String str = String.valueOf(now);

                for (int i = end.length()-2; i >=0 ; i--) {
                    str = stack.pop() + str;
                }

                if (str.equals(end)) {

                    while (!trashStack.isEmpty()) {
                        stack.push(trashStack.pop());
                    }


                } else {
                    for (int i = 0; i < str.length()-1; i++) {
                        stack.push(str.charAt(i));
                    }
                    trashStack.push(now);
                }


            } else {
                trashStack.push(now);
            }

        }


        if (trashStack.isEmpty()) {
            System.out.println("FRULA");

        } else {
            String answer = "";
            while (!trashStack.isEmpty()) {
                char now = trashStack.pop();
                answer += now;
            }

            System.out.println(answer);
        }






    }


}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Solution9935 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String start = br.readLine();
//        String end = br.readLine();
//        int endLen = end.length();
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < start.length(); i++) {
//            sb.append(start.charAt(i));  // 스택처럼 문자열 추가
//
//            // 스택의 끝 부분에서 폭발 문자열 검사
//            if (sb.length() >= endLen && sb.substring(sb.length() - endLen).equals(end)) {
//                sb.delete(sb.length() - endLen, sb.length());  // 폭발 문자열 삭제
//            }
//        }
//
//        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
//    }
//}
