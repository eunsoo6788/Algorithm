package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15565 {

    /**
     * 백준 : 귀여운 라이언
     * 알고리즘 : 투 포인터
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }


        int min = Integer.MAX_VALUE;
        int nowCount = 0;


        int low = 0;
        int high = 0;

        if (arr[0] == 1) {
            nowCount++;
        }


        while (low <= high) {



            if (nowCount == target) {
                min = Math.min(min, high - low + 1);

                if (arr[low] == 1) {
                    nowCount--;
                }

                low++;
            }


            if (nowCount < target) {
                if (high < num-1) {
                    high++;
                    if (arr[high] == 1) {
                        nowCount++;
                    }
                } else {
                    if (arr[low] == 1) {
                        nowCount--;
                    }
                    low++;
                }
            }
        }

        if (min >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }


    }
}
