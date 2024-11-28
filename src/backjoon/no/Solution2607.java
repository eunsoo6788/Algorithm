package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2607 {

    /**
     * 백준 : 비슷한 단어 2607
     * 알고리즘 :
     * not sol
     * 실버 2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String[] arr = new String[num-1];
        for (int i = 0 ; i < num-1 ; i++) {
            arr[i] = br.readLine();
        }


        Map<Character,Integer> strMap = new HashMap<>();
        for (int i = 0 ; i < str.length(); i++) {
            strMap.put(str.charAt(i),strMap.getOrDefault(str.charAt(i),0) +1);
        }

        int answer = 0;
        for (int i = 0 ; i < num - 1 ; i++) {
            Map<Character,Integer> wordMap = new HashMap<>();

            for (int j = 0 ; j < arr[i].length(); j++) {
                wordMap.put(arr[i].charAt(j),wordMap.getOrDefault(arr[i].charAt(j),0) +1);
            }

            int sum = 0;
            for (Character key : strMap.keySet()){
                if (wordMap.getOrDefault(key, 0) != 0) {
                    sum += Math.abs(strMap.get(key) - wordMap.getOrDefault(key, 0));
                }
            }

            for (Character key : wordMap.keySet()){
                if (strMap.getOrDefault(key, 0) == 0) {
                    sum += wordMap.get(key);
                }
            }

            int lengthDiff = Math.abs(str.length() - arr[i].length());

            if ((lengthDiff == 0 && sum <= 2) || (lengthDiff == 1 && sum <= 1) ) {
                answer++;
            }
        }


        System.out.println(answer);

    }


}
