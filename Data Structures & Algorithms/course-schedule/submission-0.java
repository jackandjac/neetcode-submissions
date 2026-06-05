class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public boolean canFinish(int nc, int[][] preq) {
        int[] degree = new int[nc];
        int[] status = new int[nc];
        for (int[] pre: preq) {
            graph.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
            degree[pre[0]]++;
        }

        for (int i = 0; i < nc; i++) {
            if (degree[i] == 0) {
                status[i] = 2;
                continue;
            }
            if (!dfs(i, status)){
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int idx, int[] status) {
        if (status[idx] == 1) {
            return false;
        }
        if (status[idx] == 2) {
            return true;
        }
        if (!graph.containsKey(idx)){
            status[idx] =2;
            return true;
        }

        status[idx] = 1;
        for(int candidate: graph.get(idx)) {
            if (status[candidate] == 1) {
                return false;
            } else if (status[candidate] == 0 && !dfs(candidate, status)) {
                return false;
            }
        }
        status[idx] = 2; 
        return true;
    }


}
