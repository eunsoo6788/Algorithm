package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution29160 {

    /**
     * 나의 FIFA 팀 가치는?
     * <p>
     * 브론즈4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[num + 1];

        for (int i = 1; i <= 11; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int position = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            list[position].add(price);

        }


        for (int i = 0; i < year; i++) {

            for (int j = 1; j <= 11; j++) {
                if (list[j].size() == 0) {
                    continue;
                }

                list[j].sort(Comparator.naturalOrder());

                int value = list[j].get(0);
                value--;

                list[j].remove(0);
                list[j].add(value > 0 ? value : 0);

                list[j].sort(Comparator.naturalOrder());

            }
        }


        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            sum += list[i].get(0);
        }

        System.out.println(sum);


    }


}
