package backjoon.graph.euler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16168 {

    /**
     * 퍼레이드
     * 골드4
     * 오일러 공식 / 유니온 파인드
     *
     */


    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int[] arr = new int[nodeNum+1];


        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr[v1]++;
            arr[v2]++;
        }

        int hol = 0;

        for (int i = 1 ; i <= nodeNum ; i++) {
            if (arr[i] % 2 == 1) {
                hol++;
            }
        }



        if (hol == 0 || hol == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        




    }

}
