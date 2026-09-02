class Solution {
    int[] parent;
    int[] rank;
    int count;
    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        for (int[] edge:edges) {
            this.union(edge[0], edge[1]);
        }
        return count;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x, int y) {
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
}
