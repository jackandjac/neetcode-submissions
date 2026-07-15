class Solution {
    private int[][] dirs = new int[][]{{1,  0}, {0, 1}};
    public int numIslands(char[][] grid) {
        Union uf = new Union(grid);
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int d = 0; d < dirs.length; d++) {
                        int r = dirs[d][0] + i;
                        int c = dirs[d][1] + j; 
                        if (r < m && c < n && grid[r][c] == '1') {
                            uf.union(i * n + j, r * n + c );
                        }
                    }
                }
            }
        }
        return uf.getCount();

    }
}
class Union {
    private int[] parent;
    private int[] rank;
    private int count = 0;
    public Union(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m *n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                } else {
                    parent[i * n + j] = -1;
                }
            }
        }
    }
    public int find (int x ) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union (int x, int y ) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }

        if (rank[py] > rank[px]) {
            int temp = py;
            py = px;
            px = temp;
        }
        parent[py] = px;
        if (rank[px] == rank[py]) {
            rank[px]++; 
        }
        count--;

    }
    public int getCount() {
        return this.count;
    }
}
