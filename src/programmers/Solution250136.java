package programmers;

public class Solution250136 {

    public int solution(int[][] land) {
        int answer = 0;

        int size = land[0].length;



        // 가로 길이 만큼 시추 양을 계산 한다.
        for (int i = 0; i < size; i++) {
            // 매번 계산 마다 visited가 초기화 되어야 한다.
            boolean[][] visited = new boolean[land.length][size];

            int oilSum = 0;
            // 시추 기둥을 꽂았을때 시추 가능한 지점이 있다면 시추
            for (int j = 0; j < land.length; j++) {
                if (!visited[j][i] && land[j][i] == 1) {
                    visited[j][i] = true;
                    oilSum += dfs(visited, land, j , i);
                }
            }
            // 최대값을 answer에 저장
            answer = Math.max(answer, oilSum);
        }




        return answer;
    }

    private static int dfs(boolean[][] visited, int[][] land, int y, int x) {

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int index = 1;

        for (int i =0 ; i < 4 ; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >=0 && ny < land.length && nx < land[0].length
                    && land[ny][nx] == 1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                index += dfs(visited, land, ny, nx);
            }


        }


        return index;
    }

    public static void main(String[] args) {
        Solution250136 solution = new Solution250136();
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution.solution(land));
    }

}
