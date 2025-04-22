 package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6236 {

    /**
     * 연결 요소의 개수
     * 그리디
     * 실버1
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        String[] list = new String[m];
        for (int i = 0; i < m; i++) {
            list[i] = br.readLine();
        }

        Arrays.sort(arr);
        Arrays.sort(list);

        int count = 0;
        int nowIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = nowIndex; j < n; j++) {
                if (arr[j].startsWith(list[i])) {
                    count++;
                    nowIndex = j;
                    break;
                }

                if (arr[j].charAt(0) > list[i].charAt(0)) {
                    break;
                }
            }
        }

        System.out.println(count);

    }

}
