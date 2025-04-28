package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1263 {

    /**
     * 시간 관리
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = time;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o2[0] - o1[0];
                    }
                    return o2[1] - o1[1];
                }
        );

        int time = arr[0][1];

        for (int i = 0; i < num; i++) {

            if (time > arr[i][1]) {
                time = arr[i][1];
            }

            time -= arr[i][0];
        }


        System.out.println(time < 0 ? -1 : time);





    }


}
