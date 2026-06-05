class PrefixTree {
    private TriesNode root;
    public PrefixTree() {
         root = new TriesNode();
    }

    public void insert(String word) {
        TriesNode node = root;
        for (char c: word.toCharArray()) {
            node.children.computeIfAbsent(c, k-> new TriesNode());
            TriesNode nd = node.children.get(c);
            node = nd;
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TriesNode node = root;
        for (char c: word.toCharArray()){
            if (node.children.containsKey(c)){
                TriesNode nd = node.children.get(c);
                node = nd;
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TriesNode node = root;
        for (char c: prefix.toCharArray()) {
            if (node.children.containsKey(c)) {
                TriesNode nd = node.children.get(c);
                node = nd;
            } else {
                return false;
            }
        }
        return true;
    }
    class TriesNode {
    public Map<Character, TriesNode> children = new HashMap<>();
    public char val;
    public boolean isEnd;
    public TriesNode () {}
}
}

