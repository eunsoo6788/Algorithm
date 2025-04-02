package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution14426 {

    /**
     * 접두사 찾기
     * 실버1
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int masterNum = Integer.parseInt(st.nextToken());
        int slaveNum = Integer.parseInt(st.nextToken());

        String[] master = new String[masterNum];
        String[] slave = new String[slaveNum];

        for (int j = 0; j < masterNum; j++) {
            master[j] = br.readLine();
        }

        for (int i = 0; i < slaveNum; i++) {
            slave[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < slaveNum; i++) {

            for (int j = 0; j < masterNum; j++) {

                if (master[j].length() < slave[i].length()) {
                    continue;
                }


                int low = 0;
                int high = master[j].length() - 1;
                boolean found = false;


                while (low <= high) {

                    int mid = (low + high) / 2;
                    int length = mid + 1;

                    if (length > slave[i].length()) {
                        high = mid - 1;
                    } else if (length < slave[i].length()) {
                        low = mid + 1;
                    } else {

                        if (slave[i].equals(master[j].substring(0, length))) {
                            found = true;
                        }
                        break;
                    }

                }


                if (found) {
                    count++;
                    break;
                }

            }


        }

        System.out.println(count);






    }

}
