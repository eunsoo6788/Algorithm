package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution28449 {

    /**
     * 누가이길까?
     * 골드5
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int teamANum = Integer.parseInt(st.nextToken());
        int teamBNum = Integer.parseInt(st.nextToken());

        int[] teamA = new int[teamANum];
        int[] teamB = new int[teamBNum];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < teamANum ; i++) {
            teamA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < teamBNum ; i++) {
            teamB[i] = Integer.parseInt(st.nextToken());
        }

        int win = 0;
        int draw = 0;
        int lose = 0;


        Arrays.sort(teamB);


        for (int i = 0 ; i < teamANum ; i++ ) {

            int aValue = teamA[i];

            int low = 0;
            int high = teamBNum-1;
            int mid = 0;
            boolean isSame = false;
            while (low <= high) {

                mid = (low + high) / 2;

                if (teamB[mid] > aValue) {
                    high = mid -1;
                } else if (teamB[mid] < aValue) {
                    low = mid +1;
                } else {
                    isSame = true;
                    break;
                }
            }

            if (isSame) {
                draw++;

                lose += teamBNum-mid-1;
                win += mid;
            } else {
                lose += teamBNum-mid-1;
                win += mid;

                if (teamB[mid] > aValue) {
                    lose++;
                } else {
                    win++;
                }
            }





        }


        System.out.println(Arrays.binarySearch(teamB,3));

        System.out.println(win + " " + lose + " " + draw);




    }

}
