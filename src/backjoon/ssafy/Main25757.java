package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        Character game = st.nextToken().charAt(0);


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String str = br.readLine();

            map.put(str, 1);
        }


        if (game == 'Y') {
            System.out.println(map.size()/1);
        } else if (game == 'F') {
            System.out.println(map.size()/2);
        } else {
            System.out.println(map.size()/3);

        }
    }

}
