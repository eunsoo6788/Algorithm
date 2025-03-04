package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution18258 {

    /**
     * 큐 2 18258
     * 자료구조 - 우선순위
     * 실버2
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String type = st.nextToken();

            if (type.equals("push")) {
                dq.push(Integer.parseInt(st.nextToken()));
            } else if (type.equals("pop")) {

                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.pollLast());
                }
            } else if (type.equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (type.equals("size")) {
                System.out.println(dq.size());
            } else if (type.equals("front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peekFirst());
                }
            } else if (type.equals("back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peekLast());
                }
            }




        }






    }

}
