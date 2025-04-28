package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution11509Re {

    /**
     * 풍선 맞추기
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        List<Integer> list = new ArrayList<>();
        list.add(arr[0]-1);
        int max = 0;

        for (int i = 1; i < n; i++) {

            int size = list.size();
            boolean flag = false;

            for (int j = 0; j < size; j++) {
                if (list.get(j) == arr[i]) {
                    list.remove(j);
                    list.add(arr[i]-1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                list.add(arr[i]-1);
            }

            max = Math.max(max, list.size());
        }


        System.out.println(max);


    }

}
