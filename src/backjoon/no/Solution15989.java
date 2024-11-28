package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution15989 {

    /**
     * 백준 : 1,2,3 더하기 4 15989
     * 알고리즘 : 백트래킹
     * not sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<int[]> answer = new HashSet<>();

        bfs(0,answer,new ArrayList<>(),0);

        System.out.println();
    }


    private static void bfs(int sum, Set<int[]> list, List<Integer> arr, int depth) {

        if (sum >= 4) {

            if (sum == 4) {
                Collections.sort(arr);
                list.add(arr.stream().mapToInt(Integer::intValue).toArray());
            }

            return;
        }


        for (int i = 0; i < 3; i++) {

            if (i == 0) {
                sum += 1;
                arr.add(1);
                bfs(sum, list, arr, depth + 1);
                arr.remove(arr.size()-1);
                sum -= 1;
            }

            if (i == 1) {
                sum += 2;
                arr.add(2);
                bfs(sum, list, arr, depth + 1);
                arr.remove(arr.size()-1);
                sum -= 2;
            }

            if (i == 2) {
                sum += 3;
                arr.add(3);
                bfs(sum, list, arr, depth + 1);
                arr.remove(arr.size()-1);
                sum -= 3;
            }

        }


    }


}
