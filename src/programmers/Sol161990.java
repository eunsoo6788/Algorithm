package programmers;

public class Sol161990 {


    public int[] solution(String[] wallpaper) {

        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {

                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }

            }
        }

        return new int[]{minX, minY, maxX+1, maxY+1};
    }


    public static void main(String[] args) {
        Sol161990 sol = new Sol161990();
        String[] wallpaper =
                {
                        ".#...",
                        "..#..",
                        "...#."
                };
        sol.solution(wallpaper);
    }
}
