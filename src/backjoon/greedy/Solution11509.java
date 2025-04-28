package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11509 {

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


        int count = 1;
        int height = arr[0];
        int direction = 0;
        for (int i = 0; i < n; i++) {


            if (direction == 0) {
                if (i < n - 1) {
                    direction = arr[i + 1] - arr[i];
                    height += direction;
                } else {
                    count++;
                }

            } else if (direction == 1 && arr[i] == height) {
                height += direction;

            } else if (direction == -1 && arr[i] == height) {
                height += direction;
            } else {
                count++;
                if (i < n - 1) {
                    direction = arr[i + 1] - arr[i];
                    height = arr[i] + direction;
                }
            }


        }

        System.out.println(count);




    }

}
