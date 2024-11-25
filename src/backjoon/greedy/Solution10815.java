package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int myCardNum = Integer.parseInt(br.readLine());
        StringTokenizer myCardStringTokenizer = new StringTokenizer(br.readLine(), " ");

        int[] myCard = new int[myCardNum];
        for (int i = 0; i < myCardNum; i++) {
            myCard[i] = Integer.parseInt(myCardStringTokenizer.nextToken());
        }

        int cardNum = Integer.parseInt(br.readLine());
        StringTokenizer cardStringTokenizer = new StringTokenizer(br.readLine(), " ");

        int[] card = new int[cardNum];
        for (int i = 0; i < cardNum; i++) {
            card[i] = Integer.parseInt(cardStringTokenizer.nextToken());
        }


        Arrays.sort(myCard);


        int[] answer = new int[cardNum];
        for (int i = 0 ; i< card.length ; i++) {
            long low = 0;
            long high = myCard.length - 1;

            while(low <= high) {

                int mid = (int) (high + low) / 2;

                int value = myCard[mid];


                if (value < card[i]){
                    low = mid + 1;
                } else if (value > card[i]){
                    high = mid - 1;
                } else {
                  answer[i] = 1;
                  break;
                }
            }

        }


        for (int i =0 ; i < answer.length ; i++)  {
            System.out.print(answer[i] + " ");
        }
    }
}
