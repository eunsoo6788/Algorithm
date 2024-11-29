package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution12919 {

    /**
     * 백준 : A와 B 2
     * 알고리즘 : 백트래킹
     * not sol
     * 골드 5
     */


    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String start = br.readLine();
        String target = br.readLine();

        backTracking(start,target);

        System.out.println(count == 0? 0 : 1);
    }


    private static void backTracking(String str, String target) {

        if (str.length() == target.length()) {

            if (str.equals(target)) {
                count++;
            }

            return;
        }


        for (int i = 0 ; i < 2 ; i++) {

            if (i == 0) {
                str += "A";
                backTracking(str, target);
                str = str.substring(0,str.length()-1);
            }

            if (i == 1) {
                str += "B";
                String tmp = "";

                for ( int j = str.length()-1 ; j >= 0  ; j--) {
                    tmp += str.charAt(j);

                }

                backTracking(tmp,target);

                str = str.substring(0, str.length()-1);


            }

        }

    }


}
