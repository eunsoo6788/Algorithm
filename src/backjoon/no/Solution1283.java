package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1283 {

    /**
     * 백준 : 비슷한 단어 1283
     * 알고리즘 :
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] strArr = new String[num];

        for (int i = 0 ; i < num ; i++) {
            strArr[i] = br.readLine();
        }


        int[] arr = new int[num];
        Set<Character> characterSet = new HashSet<>();



        for (int i = 0 ; i < num ; i++) {

            String[] tmp = strArr[i].split(" ");

            for (int k = 0 ; k < tmp.length ; k++) {

                for (int j= 0 ; j< strArr[i].length() ; j++) {

                    if (!characterSet.contains(Character.toLowerCase(strArr[i].charAt(j))) ) {
                        characterSet.add(Character.toLowerCase(strArr[i].charAt(j)));
                        break;
                    }

                }
            }
        }


    }


}
