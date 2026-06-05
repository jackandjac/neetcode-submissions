class Solution {
    private int[][] dirs = new int[][]{{0, 1},{0, -1}, {1, 0}, {-1, 0}};
    TriesNode root= new TriesNode();
    public List<String> findWords(char[][] board, String[] words) {
        
        for (String word: words) {
            TriesNode node = root;
            for (char c: word.toCharArray()) {
                node.children.computeIfAbsent(c, k-> new TriesNode());
                TriesNode nd = node.children.get(c);
                node = nd;
            }
            node.word= word;
        }
        List<String> results = new ArrayList<>();
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrack(i, j, board, root.children.get(board[i][j]), results);
                }
            }
        }
        return results;
    }

    private void backtrack(int r, int c, char[][] board, TriesNode node, List<String> results) {
        if (node != null && node.word != null ) {
            results.add(node.word);
            node.word = null;
        }
        char backup = board[r][c];
        board[r][c] = '?';
        for (int i = 0; i < dirs.length; i++) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc]!= '?') {
                if (node.children.containsKey(board[nr][nc])) {
                    backtrack(nr, nc, board, node.children.get(board[nr][nc]), results);
                }
            }
        }
        board[r][c] = backup;
    }
}

class TriesNode {
    public Map<Character, TriesNode> children= new HashMap<>();
    public String word;
    public TriesNode() {

    }
}
