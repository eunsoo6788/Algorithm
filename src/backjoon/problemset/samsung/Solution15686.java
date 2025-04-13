
package backjoon.problemset.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15686 {

    /**
     * 치킨배달
     * 구현
     * 골드5
     * 문제집 : 삼성 소프트웨어 기출
     */


    private static int num;
    private static int minDistance;
    private static int size;

    private static List<int[]> chicken;
    private static List<int[]> store;
    private static List<int[]> customer;

    private static int[][] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        minDistance = Integer.MAX_VALUE;

        store = new ArrayList<>();
        chicken = new ArrayList<>();
        customer = new ArrayList<>();


        arr = new int[num][num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    customer.add(new int[]{j, i});
                }

                if (arr[i][j] == 2) {
                    chicken.add(new int[]{j, i});
                }
            }
        }


        visited = new boolean[chicken.size()];


        backtracking(0, 0);

        System.out.println(minDistance);

    }


    private static void backtracking(int depth, int index) {


        if (depth == size) {
            cal();
            return;
        }


        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                store.add(chicken.get(i));
                backtracking(depth + 1, i);
                store.remove(depth);
                visited[i] = false;
            }


        }


    }


    private static void cal() {

        int distance = 0;

        for (int i = 0; i < customer.size(); i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < size; j++) {

                int[] customerPoint = customer.get(i);
                int[] storePoint = store.get(j);


                min = Math.min(min,Math.abs(storePoint[0] - customerPoint[0]) + Math.abs(storePoint[1] - customerPoint[1]));
            }


            distance += min;

        }


        minDistance = Math.min(minDistance, distance);

    }

}
