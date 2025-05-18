package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main32404 {

    /**
     * 일이 커졌어
     * 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int low = n/2;
        int high = low+1;

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 1; i <= n; i++) {

            if (index % 2 == 0) {
                sb.append(high + " ");
                high++;
            } else {
                sb.append(low + " ");
                low--;
            }

            index++;
        }


        System.out.println(sb);



    }

}
