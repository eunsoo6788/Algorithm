package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1072 {

    /**
     * 게임
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = Long.parseLong(st.nextToken());
        long win = Long.parseLong(st.nextToken());


        long low = 1;
        long high = 1_000_000_000L;
        long nowRate = win*100 /total;
        long min = Long.MAX_VALUE;


        while (low <= high) {
            long mid = (low + high) / 2;
            long now = (win + mid) *100 / (total+mid);

            if (now > nowRate) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(min == Long.MAX_VALUE ? -1 : min);


    }








}
