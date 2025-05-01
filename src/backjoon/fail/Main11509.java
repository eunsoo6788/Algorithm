package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11509 {

    /**
     * 풍선 맞추기
     * 골드5
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        boolean[] visited = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!visited[arr[i]+1]) {
                count++;
                visited[arr[i]] = true;
            } else {
                visited[arr[i]+1] = false;
                visited[arr[i]] = true;
            }
        }

        System.out.println(count);



    }






}
