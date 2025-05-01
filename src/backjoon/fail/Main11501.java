package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11501 {

    /**
     * 주식
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());


        for (int t = 0; t < test; t++) {

            int n = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Comparator.naturalOrder());

            int[] maxList = new int[n];
            for (int i = 0; i < n; i++) {
                maxList[i] = arr.get(0);


            }

        }


    }


}
