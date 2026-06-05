class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    public boolean canFinish(int nc, int[][] preqs) {
        int[] degree = new int[nc];
        for (int[] preq: preqs) {
            graph.computeIfAbsent(preq[1], k-> new ArrayList<>()).add(preq[0]);
            degree[preq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;

        for (int i = 0; i < nc; i++) {
            if (degree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited++;
            if (graph.containsKey(node)) {
                for (int candidate: graph.get(node)) {
                    degree[candidate]--;
                    if (degree[candidate] == 0) {
                        queue.offer(candidate);
                    }
                }
            }
        }
        return visited == nc ;
    }
}
