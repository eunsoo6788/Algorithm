package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution13305 {

    /**
     * 백준 : 주유소
     * 알고리즘 : 그리디
     * not sol
     * 실버 3
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] distant = new int[num-1];
        for (int i = 0 ; i < num -1 ; i++) {
            distant[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] price = new int[num];
        for (int i = 0 ; i < num ; i++) {
            price[i] = Integer.parseInt(st1.nextToken());
        }

        int sum = 0;

        for (int i = 0 ;  i < num ; i++) {
            int distantSum = 0;
            for (int j = i+1 ; j < num ; j++) {
                distantSum += distant[j-1];
                if (price[i] >= price[j]) {
                    sum += distantSum * price[i];
                    i = j -1 ;
                    break;
                }
            }


        }

        System.out.println(sum);



    }





}
