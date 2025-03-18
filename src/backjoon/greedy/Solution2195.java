package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2195 {


    /**
     * 문자열 복사 2195
     * 골드 5
     * 알고리즘 : 그리디
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();



        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            for (int j = s.length(); j > 0; j--) {

                int end = j+i;
                if (end> p.length()) {
                    end = p.length();
                }

                String str = p.substring(i, end);
                if (s.indexOf(str) != -1) {
                    count++;
                    i = end -1;
                    break;
                }
            }
        }

        System.out.println(count);



    }
}
