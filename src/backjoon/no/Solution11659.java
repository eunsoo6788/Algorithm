package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution11659 {

    /**
     * 백준 : 구간합 11659
     * 알고리즘 :
     * not sol
     * 실버3
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        int[] sumArr = new int[num];


        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());

            if (i != 0 ) {
                sumArr[i] = sumArr[i-1] + arr[i];
            } else {
                sumArr[0] = arr[0];
            }
        }

        for (int i = 0 ; i < test ; i++) {

            StringTokenizer answerSt = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(answerSt.nextToken()) - 1;
            int end = Integer.parseInt(answerSt.nextToken()) - 1;

            if (start > 0) {
                System.out.println(sumArr[end]-sumArr[start-1]);
            } else {
                System.out.println(sumArr[end]);
            }


        }






    }




}
