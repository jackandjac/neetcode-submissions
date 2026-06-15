class PrefixTree {
    private TriesNode root = new TriesNode();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        TriesNode node = root;
        for (char c: word.toCharArray()){
            node.children.computeIfAbsent(c, k-> new TriesNode());
            TriesNode candidate = node.children.get(c);
            node = candidate;
        }
        node.end = true;
    }

    public boolean search(String word) {
        TriesNode node = root;
        for (char c: word.toCharArray()) {
            if(node.children.containsKey(c)) {
                TriesNode candidate = node.children.get(c);
                node = candidate;
            } else {
                return false;
            }
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TriesNode node = root;
        for(char c: prefix.toCharArray()){
            if (node.children.containsKey(c)){
                TriesNode candidate = node.children.get(c);
                node= candidate;
            } else {
                return false;
            }
        }
        return true;
    }
}
class TriesNode {
    public Map<Character, TriesNode> children = new HashMap<>();
    public char val;
    public boolean end;
    public TriesNode() {

    } 
}
