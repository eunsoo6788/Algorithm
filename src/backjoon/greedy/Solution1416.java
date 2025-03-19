package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1416 {

    /**
     * 도서관 1416
     * 알고리즘 : 그리디
     * sol
     * 골드4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int container = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value < 0) {
                negative.offer(value);
            } else if (value > 0) {
                positive.offer(value);
            }
        }

        int sum = 0;
        int max = 0;

        while (!positive.isEmpty()) {

            int value = positive.poll();

            sum += value * 2;
            max = Math.max(max, value);

            for (int i = 0 ; i < container -1 ; i++) {
                if (positive.isEmpty()) {
                    break;
                }
                positive.poll();
            }

        }


        while (!negative.isEmpty()) {

            int value = Math.abs(negative.poll());

            sum += value * 2;
            max = Math.max(max, value);

            for (int i = 0 ; i < container -1; i++) {
                if (negative.isEmpty()) {
                    break;
                }
                negative.poll();
            }

        }

        System.out.println(sum-max);

    }

}
