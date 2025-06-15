package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main15789 {

    /**
     * 왕국은 한솔 왕국을 이길 수 있을까?
     * 골드4
     * 유니온 파인드
     */

    private static int[] parents;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        parents = new int[nodeNum+1];
        for (int i = 0; i <= nodeNum; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);

        }

        st = new StringTokenizer(br.readLine());
        int ctpCity = find(Integer.parseInt(st.nextToken()));
        int hansolCity = find(Integer.parseInt(st.nextToken()));


// 경로 압축 수행
//        for (int i = 1; i <= nodeNum; i++) {
//            find(i);
//        }

// 이제 map 만들기
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nodeNum; i++) {
            map.put(parents[i], map.getOrDefault(parents[i], 0) + 1);
        }


        int num = map.get(ctpCity);
        map.remove(hansolCity);
        map.remove(ctpCity);

        List<Integer> list= new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());


        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Math.min(count, list.size()); i++) {
            num += list.get(i);
        }


        System.out.println(num);

    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }


    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }

}
