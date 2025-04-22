package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution16938 {

    /**
     * 연결 요소의 개수
     * 그리디
     * 실버1
     */

    private static int num;
    private static int low;
    private static int high;
    private static int abs;
    private static int count = 0;

    private static List<Integer> list = new ArrayList<>();
    private static int[] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        low = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());
        abs = Integer.parseInt(st.nextToken());

        arr = new int[num];
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,0,0);
        System.out.println(count);

    }

    private static void backTracking(int depth, int index, int sum) {

        if (sum >= low && sum <= high && depth >= 2) {
            list.sort(Comparator.naturalOrder());
            if (Math.abs(list.get(0) - list.get(list.size()-1)) >= abs) {
                count++;
            }
        }

        if (depth == num) {
            return;
        }


        for (int i = index ; i < num ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                backTracking(depth+1, i, sum + arr[i]);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }


    }

}
