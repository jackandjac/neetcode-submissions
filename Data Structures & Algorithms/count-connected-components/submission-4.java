class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int[] edge: edges) {
            graph.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }

            queue.offer(i);
            count++;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (!visited.contains(cur)) {
                    visited.add(cur);
                    if (graph.containsKey(cur)) {
                        for (Integer candidate: graph.get(cur)) {
                            if (!visited.contains(candidate)) {
                                queue.offer(candidate);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
