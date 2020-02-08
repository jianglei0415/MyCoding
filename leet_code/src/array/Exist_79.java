package array;

/**
 * @author: jianglei
 * @date: 2020/2/8 16:28
 * <p>
 * 题号：#79 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，
 * 找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，
 * 通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Exist_79 {
    int row;
    int col;
    char[][] board;
    String word;
    boolean[][] marked;

    private boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        if (row == 0) {
            return false;
        }
        if (row * col < word.length()) {
            return false;
        }

        marked = new boolean[row][col];
        this.board = board;
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            if (isValid(i - 1, j) && !marked[i - 1][j] && dfs(i - 1, j, start + 1)) {
                return true;
            } else if (isValid(i, j + 1) && !marked[i][j + 1] && dfs(i, j + 1, start + 1)) {
                return true;
            } else if (isValid(i + 1, j) && !marked[i + 1][j] && dfs(i + 1, j, start + 1)) {
                return true;
            } else if (isValid(i, j - 1) && !marked[i][j - 1] && dfs(i, j - 1, start + 1)) {
                return true;
            } else {
                marked[i][j] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        Exist_79 exist_79 = new Exist_79();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        boolean exist1 = exist_79.exist(board, word1);
        System.out.println(exist1);

        String word2 = "SEE";
        boolean exist2 = exist_79.exist(board, word2);
        System.out.println(exist2);

        String word3 = "ABCB";
        boolean exist3 = exist_79.exist(board, word3);
        System.out.println(exist3);
    }
}
