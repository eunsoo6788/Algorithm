package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution17615 {


    /**
     * 볼 모으기
     * 실버1
     * 알고리즘 : 그리디
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<Character> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0 ; i < str.length() ; i++) {
            list.add(str.charAt(i));
            list2.add(str.charAt(i));
        }

        int blueLastPoint = num -1;
        int blueCount = 0;

        int redLastPoint = num -1;
        int redCount = 0;

        for (int i = num-1 ; i >= 0 ; i-- ) {

            if (list.get(i) == 'B') {

                if (i != blueLastPoint) {
                    list.remove(i);
                    list.add('B');
                    blueLastPoint--;
                    blueCount++;
                } else {
                    blueLastPoint--;
                }
            }


            if (list2.get(i) == 'R') {

                if (i != redLastPoint) {
                    list2.remove(i);
                    list2.add('R');
                    redLastPoint--;
                    redCount++;
                } else {
                    redLastPoint--;
                }
            }

        }


        System.out.println(Math.min(redCount, blueCount));


    }
}
