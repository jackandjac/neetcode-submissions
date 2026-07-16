class Solution {
    public boolean canFinish(int nc, int[][] prerequisites) {
        int[] degree = new int[nc];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] preq: prerequisites) {
            graph.computeIfAbsent(preq[1], k-> new ArrayList<>()).add(preq[0]);
            degree[preq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nc; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;

        while(!queue.isEmpty()){
            visited++;
            int candidate = queue.poll();
            if (graph.containsKey(candidate)) {
                for (int nexc: graph.get(candidate)) {
                    degree[nexc]--;
                    if (degree[nexc] == 0) {
                        queue.offer(nexc);
                    }
                }
            }
        }
        return visited == nc ? true: false;


    }
}
