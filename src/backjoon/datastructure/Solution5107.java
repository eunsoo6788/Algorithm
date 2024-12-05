package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5107 {


    private static String[][] str;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        /**
         * 마니또 5107
         * 자료구조
         * 실버 1
         * sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = 1;
        while (true) {


            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }

            str = new String[num][2];

            for (int i = 0 ; i < num ; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String start = st.nextToken();
                if (start.equals("0")){
                    break;
                }
                String end = st.nextToken();

                str[i][0] = start;
                str[i][1] = end;


            }


            visited = new boolean[num];


            int count = 0;

            for (int i = 0 ; i < num ; i++) {

                if (!visited[i]) {
                    bfs(i);
                    count++;
                }
            }


            System.out.println(testcase + " " + count);

            testcase++;
        }




    }

    private static void bfs(int index) {

        Queue<String[]> queue = new LinkedList<>();

        queue.add(new String[]{str[index][0], str[index][1]});
        visited[index] = true;


        while (!queue.isEmpty()) {

            String[] poll = queue.poll();


            for (int i = 0 ; i < str.length ; i++) {
                if (!visited[i]) {
                    if (poll[1].equals(str[i][0])) {
                        visited[i] = true;
                        queue.add(new String[]{str[i][0], str[i][1]});
                    }

                }
            }


        }


    }


}
