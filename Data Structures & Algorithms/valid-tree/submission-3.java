class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int[] edge: edges) {
            graph.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }

        parent.put(0, -1);
        stack.push(0);

        while(!stack.isEmpty()){
            Integer curNode = stack.pop();
            if (graph.containsKey(curNode)) {
                for (Integer subNode: graph.get(curNode)) {
                    if (parent.get(curNode).equals(subNode)) {
                        continue;
                    }

                    if (Objects.equals(parent.get(subNode), curNode)){
                        return false;
                    }

                    parent.put(subNode, curNode);
                    stack.push(subNode);
                }
            }
        }

        return parent.size() == n;
    }
}
