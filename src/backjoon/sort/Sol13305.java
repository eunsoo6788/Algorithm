package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        int[] prices = new int[total];
        int[] distances = new int[total-1];


        StringTokenizer distanceStringTokens = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < total-1; i++) {
            distances[i] = Integer.parseInt(distanceStringTokens.nextToken());
        }

        StringTokenizer priceStringTokens = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < total; i++) {
            prices[i] = Integer.parseInt(priceStringTokens.nextToken());
        }

        int sumDistance = 0;
        int sumPrice = 0;
        int addMove = 0;

        for (int i = 0; i < total; i++) {

            for (int j = i+1; j < total; j++) {
                if (prices[i] <= prices[j]) {
                    sumDistance += distances[j-1];
                    addMove++;


                    if (j == total-1) {
                        sumPrice += prices[i] * sumDistance;
                        i += addMove;
                        addMove =0;
                        sumDistance = 0;
                        break;
                    }

                } else {
                    sumDistance += distances[j-1];
                    sumPrice += prices[i] * sumDistance;
                    i += addMove;
                    addMove =0;
                    sumDistance = 0;
                    break;
                }
            }
        }

        System.out.println(sumPrice);

    }




}
