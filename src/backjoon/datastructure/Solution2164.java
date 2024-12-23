package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2164 {

    /**
     * 카드2 2164
     * 자료구조 - 큐
     * 실버4
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1 ; i <= num ;i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {


            for (int i = 0 ; i < 2 ; i++ ) {

                if (queue.size() == 1) {
                    System.out.println(queue.poll());
                    return;
                }

                if (i == 0) {
                    queue.poll();
                }

                if (i == 1) {
                    int poll = queue.poll();
                    queue.add(poll);
                }

            }

        }





    }


}
