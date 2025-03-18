package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2036 {

    /**
     * 수열의점수 2036
     * 알고리즘 : 그리디
     * not sol
     * 골드5
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                zero++;
                continue;
            }

            q.add(value);

            if (value > 0) {
                positive++;
            } else if (value < 0) {
                negative++;
            }
        }



        int sum = 0;

        while (!q.isEmpty()) {

            if (negative > 0) {

                if (negative >= 2) {

                    int a1 = q.poll();
                    int a2 = q.poll();

                    negative -= 2;
                    sum += Math.max(a1*a2, a1+a2);


                } else {
                    int value = q.poll();
                    if (zero > 0) {
                        negative--;
                        continue;
                    }

                    sum += value;
                    negative--;
                }
            } else if (positive > 0) {

                if (positive % 2 == 1) {
                    sum += q.poll();
                    positive--;
                } else {

                    int a1 = q.poll();

                    if (a1 == 1) {
                        sum += a1;
                        positive--;
                        continue;
                    }


                    int a2 = q.poll();

                    sum += Math.max(a1*a2, a1+a2);
                    positive -= 2;
                }


            }


        }

        System.out.println(sum);



    }

}
