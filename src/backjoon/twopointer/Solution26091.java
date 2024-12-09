package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution26091 {

    /**
     * 백준 : 현대모비스 소프트웨어 아카데미
     * 알고리즘 : 투 포인터
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int minAbility = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];

        StringTokenizer abilitySt = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(abilitySt.nextToken());
        }


        int low = 0;
        int high = num-1;
        int count = 0;

        Arrays.sort(arr);
        while (low < high) {

            int sum = arr[low]+ arr[high];

            if (sum >= minAbility) {
                low++;
                high--;
                count++;
            } else {
                low++;
            }
        }


        System.out.println(count);



    }
}
