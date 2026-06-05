class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(0, i, j, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(int idx, int r, int c , char[][] board, String words) {
        if (idx == words.length() -1 && words.charAt(idx) == board[r][c]) {
            return true;
        }

        if (board[r][c] != words.charAt(idx)) {
            return false;
        }
        char backup = board[r][c];

        board[r][c] = '?';

        for (int i = 0; i < dirs.length; i++) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '?'){
                if (backtrack(idx +1, nr, nc, board, words)){
                    return true;
                }
            }
        }
        board[r][c] = backup;
        return false;
    }

}
