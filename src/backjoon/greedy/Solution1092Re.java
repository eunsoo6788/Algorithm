package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1092Re {

    /**
     * 배
     * 알고리즘 : 그리디
     * 골드5
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int crainNum = Integer.parseInt(br.readLine());
        int[] crains = new int[crainNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < crainNum; i++) {
            crains[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crains);

        int containerNum = Integer.parseInt(br.readLine());
        List<Integer> containers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < containerNum; i++) {
            containers.add(Integer.parseInt(st.nextToken()));
        }
        containers.sort(Comparator.naturalOrder());

        int time =0 ;
        while (!containers.isEmpty()) {

            int count = 0;

            for (int i = 0; i < crainNum; i++) {

                int containerSize = containers.size();

                for (int j = containerSize -1; j >= 0 ; j--) {
                     if (containers.get(j) <= crains[i]) {
                         count++;
                         containers.remove(j);
                         break;
                     }
                }


            }



            if (count == 0) {
                time = -1;
                break;
            }

            time++;
        }

        System.out.println(time);

    }

}
