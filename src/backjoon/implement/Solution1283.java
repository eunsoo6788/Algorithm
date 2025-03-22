package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Solution1283 {

    /**
     * 단축키 지정
     * 구현
     * not sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Set<String> characterSet = new HashSet<>();

        for (int i = 0 ; i < num ; i++) {

            String[] str = br.readLine().split(" ");

            int index = 0;
            for (int j = 0 ; j < str.length ; j++) {
                if (characterSet.contains(String.valueOf(str[j].charAt(0)).toUpperCase(Locale.ROOT))) {
                    continue;
                }
                characterSet.add(String.valueOf(str[j].charAt(0)).toUpperCase(Locale.ROOT));

                index = j;
                break;
            }


            for (int j = 0 ; j < str.length ; j++) {

                if (index == j) {

                    System.out.print("["+str[j].charAt(0)+"]"+str[j].substring(1,str[j].length()) +" ");
                    continue;
                }

                System.out.print(str[j] + " ");
            }

            System.out.println();







        }


    }


}
