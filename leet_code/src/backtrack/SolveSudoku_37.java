package backtrack;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/9/15 22:00
 */
public class SolveSudoku_37 {
    public static void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] box = new boolean[3][3][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (1 <= num && num <= 9) {
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }
        backtrack(board, row, col, box, 0, 0);
    }

    private static boolean backtrack(char[][] board, boolean[][] row, boolean[][] col, boolean[][][] box, int x, int y) {
        if (y == board[0].length) {
            y = 0;
            x++;
            if (x == board.length) {
                return true;
            }
        }

        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                boolean canUsed = !(row[x][i] || col[y][i] || box[x / 3][y / 3][i]);
                if (canUsed) {
                    row[x][i] = true;
                    col[y][i] = true;
                    box[x / 3][y / 3][i] = true;

                    board[x][y] = (char) ('0' + i);
                    if (backtrack(board, row, col, box, x, y + 1)) {
                        return true;
                    }
                    board[x][y] = '.';

                    row[x][i] = false;
                    col[y][i] = false;
                    box[x / 3][y / 3][i] = false;
                }
            }
        } else {
            return backtrack(board, row, col, box, x, y + 1);
        }
        return false;
    }

    /**
     * 改进版
     */
    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    private boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) {
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return solveSudokuHelper(board, n + 1, row, col, box);
        }

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) {
                continue;
            }
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) {
                return true;
            }
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
