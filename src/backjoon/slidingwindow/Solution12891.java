package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12891 {

    /**
     * 백준 : DNA 비밀번호 12891
     * 알고리즘 : 슬라이딩 윈도우
     * not sol
     * 실버2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int strLength = Integer.parseInt(st.nextToken());
        int slidingSize = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] arr = new int[4];
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int answer =0 ;
        int low = 0;
        int high = slidingSize -1;


        int[] count = new int[4];
        for (int i = low ; i <= high ; i++) {

            if (str.charAt(i) == 'A'){
                count[0]++;
            }

            if (str.charAt(i) == 'C'){
                count[1]++;
            }

            if (str.charAt(i) == 'G'){
                count[2]++;
            }

            if (str.charAt(i) == 'T'){
                count[3]++;
            }
        }

        boolean valid = true;
        for (int i = 0 ; i < 4 ; i++) {

            if (arr[i] > count[i]){
                valid = false;
            }

        }

        if (valid) {
            answer++;
        }


        while (high < strLength) {

            high++;
            low++;


            if (high == strLength) {
                break;
            }

            if (str.charAt(high) == 'A'){
                count[0]++;
            }

            if (str.charAt(high) == 'C'){
                count[1]++;
            }

            if (str.charAt(high) == 'G'){
                count[2]++;
            }

            if (str.charAt(high) == 'T'){
                count[3]++;
            }


            if (str.charAt(low-1) == 'A'){
                count[0]--;
            }

            if (str.charAt(low-1) == 'C'){
                count[1]--;
            }

            if (str.charAt(low-1) == 'G'){
                count[2]--;
            }

            if (str.charAt(low-1) == 'T'){
                count[3]--;
            }

            boolean valid1 = true;
            for (int i = 0 ; i < 4 ; i++) {

                if (arr[i] > count[i]){
                    valid1 = false;
                }

            }

            if (valid1) {
                answer++;
            }


        }


        System.out.println(answer);




    }
}
