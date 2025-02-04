package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main49068 {

    /**
     * 구름 : 두루마리 휴지 공장 195698
     * 알고리즘 : 이분 탐색
     * not sol
     * 레벨3
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

        long low = 0;
        long high = 0;

        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());

            high = Math.max(high,arr[i]+length);
            low = Math.max(low,arr[i]);
        }

        long answer = 0;

        while (low <= high) {

            long sum = 0;
            long mid = (low+high) / 2;


            for (int i : arr) {
                sum +=  mid- i ;
            }

            if (sum > length) {
                high = mid -1;
            } else if (sum < length) {
                low = mid +1;
                answer = Math.max(answer, mid);
            } else {
                answer = mid;
                break;
            }
        }


        if (answer == 0 ){
            System.out.println("No way!");
        } else {
            System.out.println(answer);
        }



    }


}
