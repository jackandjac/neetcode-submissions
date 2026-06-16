class WordDictionary {
    private TriesNode root = new TriesNode();
    public WordDictionary() {

    }

    public void addWord(String word) {
        TriesNode node = root;
        for(char c: word.toCharArray()) {
            node.children.computeIfAbsent(c, k-> new TriesNode());
            TriesNode candidate = node.children.get(c);
            node = candidate;
        }
        node.end = true;
    }

    public boolean search(String word) {
        return searchNode(word, root);
    }
    private boolean searchNode(String word, TriesNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children.containsKey(c)) {
                TriesNode candidate = node.children.get(c);
                node = candidate;
            } else {
                if (c == '.') {
                    String sub = word.substring(i +1);
                    for(TriesNode candidate: node.children.values()) {
                        if (searchNode(sub, candidate)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            }
            
        }
        return node.end;
    }
}
class TriesNode {
    public Map<Character, TriesNode> children = new HashMap<>();
    public boolean end;
    public TriesNode() {

    }
}