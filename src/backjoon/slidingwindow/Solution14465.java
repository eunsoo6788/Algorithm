package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14465 {

    /**
     * 백준 : 소가 길을 건너간 이유 5 14465
     * 알고리즘 : 슬라이딩 윈도우
     * not sol
     * 실버2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());
        int fixNum = Integer.parseInt(st.nextToken());
        int brokenNum = Integer.parseInt(st.nextToken());

        int answer = 0;
        int count = 0;
        boolean[] arr = new boolean[num];

        for (int i = 0; i < brokenNum; i++) {
            arr[Integer.parseInt(br.readLine()) - 1] = true;
        }

        for (int i = 0 ; i < fixNum ; i++) {
            if (arr[i]){
                answer++;
                count++;
            }
        }


        int low = 1;
        int high = fixNum;


        for (int i = high ; i < num ; i++) {

            if (arr[high]) {
                count++;
            }

            if (arr[low-1]) {
                count--;
            }

            answer = Math.min(answer, count);

            high++;
            low++;
        }


        System.out.println(answer);

    }
}
