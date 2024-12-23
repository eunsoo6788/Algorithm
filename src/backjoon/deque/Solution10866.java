package backjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution10866 {

    /**
     * 덱 10866
     * 자료구조 - 스택
     * 실버4
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0 ; i < num ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String str = st.nextToken();


            if ("push_front".equals(str)) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }

            if ("push_back".equals(str)) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            if ("pop_front".equals(str)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
            }

            if ("pop_back".equals(str)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            }

            if ("size".equals(str)) {
                System.out.println(deque.size());
            }


            if ("empty".equals(str)) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }

            }


            if ("front".equals(str)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            }

            if ("back".equals(str)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }






        }






    }


}
