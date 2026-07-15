/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return deepCopy(node, new HashMap<>());
    }
    private Node deepCopy(Node node, Map<Integer, Node> graph ) {

        if (node == null) {
            return node;
        }

        if (graph.containsKey(node.val)) {
            return graph.get(node.val);
        }

        Node copy = new Node(node.val);
        graph.put(node.val, copy);
        List<Node> copyList = copy.neighbors;

        for (Node candidate : node.neighbors) {
            if (graph.containsKey(candidate.val)) {
                copyList.add(graph.get(candidate.val));
            } else {
                Node cp = deepCopy(candidate, graph);
                copyList.add(cp);
            }
        }
        return copy;
    }
}