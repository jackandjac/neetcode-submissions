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
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null ){
            return node;
        }   
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node nd = new Node(node.val);
        map.put(node.val, nd);
        List<Node> nChildren = nd.neighbors;
        for (Node candidate: node.neighbors) {
            if (map.containsKey(candidate.val)) {
                nChildren.add(map.get(candidate.val));
            } else {
                nChildren.add(cloneGraph(candidate));
            }
        }
        return nd;
    }
}