class Solution {
    int[] parent;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        if (edges.length != n -1) return false;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            if (!union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int x,  int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }

        if (rank[px] > rank[py]){
            parent[py] = px; 
        } else if (rank[py] > rank[px]){
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}
