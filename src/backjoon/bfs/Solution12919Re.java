package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12919Re {

    /**
     * A와 B 2 12919
     * 골드5
     * 알고리즘 : 백트래킹?
     * Not Sol
     */

    private static int diffLength = 0;
    private static String startStr;
    private static String targetStr;
    private static boolean success;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        startStr = br.readLine();
        targetStr = br.readLine();

        diffLength = targetStr.length() - startStr.length();


        backTracking(startStr, 0);

        if (success) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void backTracking(String str, int depth) {


        if (depth == diffLength) {
            if (str.equals(targetStr)) {
                success = true;
            }

            return;

        }

        backTracking(str+"A", depth+1);

        str += "B";
        String bridgeStr = "";
        for (int i = str.length()-1 ; i >= 0  ; i--) {
            bridgeStr += str.charAt(i);
        }

        backTracking(bridgeStr, depth+1);



    }


}
