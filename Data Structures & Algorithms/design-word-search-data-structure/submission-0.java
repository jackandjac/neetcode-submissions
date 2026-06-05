class WordDictionary {
    private TriesNode root = new TriesNode();
    public WordDictionary() {

    }

    public void addWord(String word) {
        TriesNode node = root;
        for (char c: word.toCharArray()) {
            node.children.computeIfAbsent(c, k-> new TriesNode());
            TriesNode nd = node.children.get(c);
            node = nd;
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return nodeSearch(word, root);
    }
    private boolean nodeSearch(String word, TriesNode root) {
        TriesNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)){
                if (c == '.') {
                    for (TriesNode candidate : node.children.values()) {
                        if (nodeSearch(word.substring(i + 1), candidate)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } else {
                node = node.children.get(c);
            }
        }
        return node.isEnd;
    }  
}
class TriesNode {
    public Map<Character, TriesNode> children = new HashMap<>();
    public boolean isEnd;
    public TriesNode(){

    }
}
