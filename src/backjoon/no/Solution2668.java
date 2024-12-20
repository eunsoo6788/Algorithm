package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2668 {

    /**
     * 백준 : 숫자고르기
     * 알고리즘 :
     * not sol
     * 골드 5
     */

    private static int count = 0;
    private static int[] arr;
    private static int[] vrr;
    private static boolean[] visited;
    private static boolean[] answer;
    private static Set<Integer> arrSet;
    private static Set<Integer> vrrSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num];
        vrr = new int[num];
        answer = new boolean[num];

        for (int i = 0 ; i < num ; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = i+1;
            vrr[i] = value;
        }

        for (int i = 0 ; i < num ; i++) {
            if (!answer[i]) {
                arrSet = new HashSet<>();
                vrrSet = new HashSet<>();
                visited = new boolean[num];

                visited[i] = true;
                arrSet.add(arr[i]);
                vrrSet.add(vrr[i]);

                dfs(vrr[i] -1);
            }

        }

        System.out.println(count);
        for (int i = 0 ;i < answer.length ; i++){
            if (answer[i]){
                System.out.println(i+1);
            }
        }

    }

    private static void dfs(int index) {

        if (visited[index]) {

            if (arrSet.size() == vrrSet.size()) {
                boolean same =true;
                for (int i : arrSet) {
                    if (!vrrSet.contains(i)) {
                        same = false;
                    }
                }

                if (same) {
                    for (int i = 0 ; i< visited.length ; i++) {
                        if (visited[i]) {
                            answer[i] = true;
                            count++;
                        }
                    }
                }

            }

            return;
        }

        visited[index] = true;
        arrSet.add(arr[index]);
        vrrSet.add(vrr[index]);
        dfs(vrr[index] -1);


    }



}
