class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] canPac = new boolean[m][n];
        boolean[][] canAtl = new boolean[m][n];

        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();

        for (int i = 0; i <n; i++) {
            pac.offer(new int[]{0, i});
            atl.offer(new int[]{m -1, i});
        }

        for (int i = 0; i < m; i++) {
            pac.offer(new int[]{i, 0});
            atl.offer(new int[]{i, n-1});
        }
        List<List<Integer>> results = new ArrayList<>();

        bfs(pac, canPac, heights);
        bfs(atl, canAtl, heights);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canPac[i][j] && canAtl[i][j]){
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }
    private void bfs(Queue<int[]> queue, boolean[][] canDo, int[][] heights) {

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            canDo[r][c] = true;
            for(int i = 0; i < dirs.length; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !canDo[nr][nc] && heights[nr][nc] >= heights[r][c] ){
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

    }
}
