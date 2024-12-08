package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5107 {


    private static String[][] str;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        /**
         * 아침 태권도 29197
         * 자료구조
         * 실버 1
         * sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];
        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, (o1,o2) -> {

            double distance1 = Math.sqrt(o1[0]*o1[0] + o1[1] * o1[1]);
            double distance2 = Math.sqrt(o2[0]*o2[0] + o2[1] * o2[1]);

            return Double.compare(distance1,distance2);
        });

        int count= 0;
        boolean[] visited = new boolean[num];
        for (int i = 0 ; i < num ; i++) {

            if (!visited[i]) {

                visited[i] = true;
                count++;

                for (int j = 0 ; j < num ; j++) {
                    if (!visited[j]) {

                        int a1 = arr[j][0] / arr[i][0];
                        int a2 = arr[j][1] / arr[i][1];

                        if (a1 == a2) {
                            visited[j] = true;
                        }

                    }
                }


            }

        }


        System.out.println(count);


    }


}
