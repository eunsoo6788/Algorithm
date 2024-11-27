package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16953 {

    /**
     * https://www.acmicpc.net/problem/16953
     * 실버2
     * 알고리즘 : dfs
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

    }

    private static void bfs(int start, int end) {

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start,1});

        while (!queue.isEmpty()) {

            long[] poll = queue.poll();

            if (poll[0] == end) {
                System.out.println(poll[1]);
                break;
            }

            if (poll[1] > end){
                System.out.println(-1);
                break;
            }

            for (int i = 0 ; i < 2 ; i++) {

                if (i == 0) {
                    queue.add(new long[]{poll[0]*2,poll[1]+1});
                }


                if (i == 1) {
                    queue.add(new long[]{poll[0]*10 + 1,poll[1]+1});
                }

            }
        }





    }


//    import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//    public class Main {
//
//        public static long endNum;
//        public static long Max;
//        public static boolean flag;
//
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            long startNum = Integer.parseInt(st.nextToken());
//            endNum = Integer.parseInt(st.nextToken());
//            Max = Integer.MAX_VALUE;
//
//            dfs(startNum, 1);
//
//
//            if (flag == false){
//                Max = -1;
//            }
//
//            System.out.println(Max);
//
//        }
//
//
//        public static void dfs(long num, int depth){
//
//            if ( num == endNum ){
//                Max = Math.min(Max,depth);
//                flag = true;
//                return;
//            }
//
//            if (num > endNum){
//                return;
//            }
//
//
//
//            dfs(num*2 , depth +1);
//            dfs(num*10+1, depth +1);
//
//
//
//
//
//
//        }
//
//
//    }
//



}
