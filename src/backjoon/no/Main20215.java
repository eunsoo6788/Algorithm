package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20215 {

    /**
     * 쿠키의 신체 측정
     * 구현
     * 실버4
     */


    private static char[][] arr;
    private static int num;

    private static int heartX;
    private static int heartY;

    private static int legY;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new char[num][num];

        for (int y = 0; y < num; y++) {
            String str = br.readLine();
            for (int x = 0; x < num; x++) {
                arr[y][x] = str.charAt(x);
            }
        }


        boolean find = false;
        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {
                if (arr[y][x] == '*') {
                    heartX = x;
                    heartY = y + 1;
                    find = true;
                    break;
                }
            }

            if (find) {
                break;
            }
        }

        int leftArm = getLeftArmLength();
        int rightArm = getRightArmLength();
        int body = getBodyLength();
        int leftLeg = getLeftLegLength();
        int lefRight = getRightLegLength();

        System.out.println((heartY+1) + " " + (heartX+1));
        System.out.println( leftArm+ " " + rightArm + " " + body + " " + leftLeg + " " + lefRight);


    }


    private static int getLeftArmLength() {
        int length = 0;
        for (int x = 0; x < heartX; x++) {
            if (arr[heartY][x] == '*') {
                length = heartX - x;
                break;
            }
        }
        return length;
    }

    private static int getRightArmLength() {
        int length = 0;
        for (int x = heartX + 1; x < num; x++) {
            if (arr[heartY][x] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }


    private static int getBodyLength() {
        int length = 0;
        for (int y = heartY + 1; y < num; y++) {
            if (arr[y][heartX] == '*') {
                length++;

                legY = y + 1;
            } else {
                break;
            }
        }
        return length;
    }


    private static int getLeftLegLength() {
        int length = 0;
        for (int y = legY; y < num; y++) {
            if (arr[y][heartX - 1] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    private static int getRightLegLength() {
        int length = 0;
        for (int y = legY; y < num; y++) {
            if (arr[y][heartX + 1] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

}
