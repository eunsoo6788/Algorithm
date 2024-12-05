package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution19638 {

    public static void main(String[] args) throws IOException {

        /**
         * 센티와 마법의 뿅망치 19638
         * 자료구조
         * 실버 1
         * sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int originCount =count;


        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            return b-a;
        });

        for (int i = 0 ; i < num ; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int check = 0;
        while (count > 0) {

            if (check > num) {
                break;
            }

            int poll = queue.poll();

            if (poll >= height && poll > 1) {
                poll /= 2;
                count--;
                queue.add(poll);
                check = 0;
            } else {
                check++;
                queue.add(poll);
            }

        }



        int max = queue.poll();

        if (max >= height) {
            System.out.println("NO");
            System.out.println(max);
        } else {
            System.out.println("YES");
            System.out.println(originCount-count);
        }




    }


}
