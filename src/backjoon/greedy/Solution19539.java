package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution19539 {

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

        int one = 0;
        int two = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 3;

            if (arr[i] == 1) {
                one++;
            } else if (arr[i] == 2) {
                two++;
            }
        }


        if (one == two) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



    }



}
