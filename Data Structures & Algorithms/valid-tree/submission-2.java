class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n -1) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int[] edge: edges){
            graph.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }
        parent.put(0, -1);
        stack.push(0);

        while(!stack.isEmpty()){
            Integer node = stack.pop();

            if (graph.containsKey(node)) {
                for (int neighbor: graph.get(node)){
                    if (parent.get(node) == neighbor) {
                        continue;
                    }
                    if (parent.get(neighbor) == node) {
                        return false;
                    }

                    parent.put(neighbor, node);
                    stack.push(neighbor);
                } 
            }
        }
        return parent.size() == n;
    }
}
