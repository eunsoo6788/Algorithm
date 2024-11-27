package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1325 {

    /**
     * https://www.acmicpc.net/problem/1325
     * 실버1
     * 알고리즘 : dfs bfs
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> list = new ArrayList<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }


    }

    private static void bfs(List<int[]> list, boolean[] visited, int start, int end, int index) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, end, 1});
        visited[index] = true;


        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < list.size(); i++) {
                if (!visited[i] && poll[1] == list.get(i)[0]) {
                    visited[i] = true;
                    queue.add(new int[]{list.get(i)[0], list.get(i)[1], poll[2]+1});
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
