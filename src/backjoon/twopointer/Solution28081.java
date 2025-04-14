package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution28081 {

    /**
     * 직사각형 피자
     * 투 포인터
     * not sol
     * 실버1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());


        int yNum = Integer.parseInt(br.readLine());
        int[] arrY = new int[yNum + 1];
        if (yNum == 0) {
            arrY[0] = ySize;
        } else {
            st = new StringTokenizer(br.readLine());
            arrY[0] = Integer.parseInt(st.nextToken());
            int beforeY = arrY[0];
            for (int i = 1; i < yNum; i++) {
                int now = Integer.parseInt(st.nextToken());
                arrY[i] = now - beforeY;
                beforeY = now;
            }
            arrY[yNum] = ySize - beforeY;
        }




        int xNum = Integer.parseInt(br.readLine());
        int[] arrX = new int[xNum + 1];
        if (xNum == 0) {
            arrX[0] = xSize;
        } else {
            st = new StringTokenizer(br.readLine());
            arrX[0] = Integer.parseInt(st.nextToken());
            int beforeX = arrX[0];
            for (int i = 1; i < xNum; i++) {
                int now = Integer.parseInt(st.nextToken());
                arrX[i] = now - beforeX;
                beforeX = now;
            }
            arrX[xNum] = xSize - beforeX;
        }



        int totalSize = (yNum + 1) * (xNum + 1);
        int[] arr = new int[totalSize];

        int index = 0;

        for (int y = 0; y < arrY.length; y++) {
            for (int x = 0; x < arrX.length; x++) {
                arr[index] = arrY[y] * arrX[x];
                index++;
            }
        }


        Arrays.sort(arr);


        int low = 0;
        int high = arr.length - 1;
        int mid = 0;


        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] > limit) {
                high = mid -1;
            } else if (arr[mid] < limit) {
                low = mid + 1;
            } else {
                break;
            }
        }


        if (arr[mid] == limit) {
            System.out.println(mid+1);
        } else {
            System.out.println(mid);
        }


    }
}
