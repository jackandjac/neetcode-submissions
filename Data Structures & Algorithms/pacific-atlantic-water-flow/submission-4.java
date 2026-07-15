class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int i = 0; i < m ; i++) {
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, n -1});
        }
        for (int i = 0; i < n; i++) {
            pacQueue.offer(new int[]{0, i} );
            atlQueue.offer(new int[]{m -1, i});
        }
        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]){
                    list.add(List.of(i, j));
                }
            }
        }
        return list;
        
    }

    private void bfs(Queue<int[]> queue, boolean[][] flow, int[][] heights) {
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            flow[r][c] = true;

            for (int i = 0; i < dirs.length; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if (nr >=0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] >= heights[r][c] && !flow[nr][nc]){
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
