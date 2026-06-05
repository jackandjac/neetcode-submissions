class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (backtrack(0, i, j, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(int pos, int r, int c, char[][] board, String word){
        if (pos == word.length() - 1 && word.charAt(pos) == board[r][c] ) {
            return true;
        }
        if (board[r][c] != word.charAt(pos)) {
            return false;
        }

        char backup = board[r][c];
        board[r][c] = '?';

        for (int j = 0; j < dirs.length; j++) {
            int nr = r + dirs[j][0];
            int nc = c + dirs[j][1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '?') {
                if (backtrack(pos +1, nr, nc, board, word)){
                    return true;
                }
            }
        }
        board[r][c] = backup;
        return false;
    }
}
