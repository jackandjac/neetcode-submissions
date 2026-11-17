class PrefixTree {
    private TriesNode root = new TriesNode();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TriesNode cur = root;
        for(char c: word.toCharArray()) {
            cur.children.computeIfAbsent(c, k-> new TriesNode());
            cur = cur.children.get(c);
            cur.val = c;
        }
        cur.end = true;
    }

    public boolean search(String word) {
        TriesNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        TriesNode cur = root;
        for (char c: prefix.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
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
