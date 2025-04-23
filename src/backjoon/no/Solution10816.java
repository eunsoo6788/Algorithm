package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution10816 {

    /**
     * 숫자 카드2
     * 이분탐색
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[num2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < num2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num2; i++) {
            sb.append(map.getOrDefault(arr2[i],0)).append(" ");
        }

        System.out.println(sb);


    }




}
