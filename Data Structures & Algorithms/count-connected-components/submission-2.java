class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int[] edge: edges) {
            graph.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if(visited.contains(i)){
                continue;
            }
            queue.offer(i);
            count++;
            while(!queue.isEmpty()) {
                Integer node = queue.poll();

                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);

                if (graph.containsKey(node)) {
                    for (Integer candidate: graph.get(node)) {
                        if (!visited.contains(candidate)) {
                            queue.offer(candidate);
                        }
                    }
                }
                
            }
           
        }
        return count;
    }
}
