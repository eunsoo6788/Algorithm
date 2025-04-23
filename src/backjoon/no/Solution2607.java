package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2607 {

    /**
     * 비슷한 단어
     * 자료구조, 구현
     * 실버2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[num];

        Map<Character, Integer>[] map = new Map[num];
        for (int i = 0; i < num; i++) {
            map[i] = new HashMap<>();
        }

        for (int i = 0; i < num; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map[i].put(c, map[i].getOrDefault(c,0) + 1);
            }

        }


        for (int i = 0; i < num; i++) {


            for (int j = i+1; j < num; j++) {
                int diff = 0;

                for (char c : map[i].keySet()) {
                    int origin = map[i].getOrDefault(c,0);
                    int target = map[j].getOrDefault(c,0);

                    diff += Math.abs(origin - target);
                }

                if (diff <= 1) {
                    visited[i] = true;
                    visited[j] = true;

                    break;
                }

            }
        }

        int count = 0;

        for (int i = 0; i < num; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);


    }




}
