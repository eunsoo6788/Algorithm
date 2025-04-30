package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1764 {

    /**
     * 듣보잡
     * 실버4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }


        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                count++;
                list.add(str);
            }
        }


        System.out.println(count);
        list.sort(Comparator.naturalOrder());
        for (String str : list) {
            System.out.println(str);
        }

    }


}
