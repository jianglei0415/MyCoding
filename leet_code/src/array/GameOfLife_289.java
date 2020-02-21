package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/21 20:27
 * <p>
 * 题号：#289 生命游戏
 * <p>
 * 根据百度百科，
 * 生命游戏，简称为生命，
 * 是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，
 * 每一个格子都可以看成是一个细胞。
 * 每个细胞具有一个初始状态 live（1）即为活细胞，
 * 或 dead（0）即为死细胞。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，
 * 写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
 * 其中细胞的出生和死亡是同时发生的。
 * <p>
 * 示例:
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * <p>
 * 进阶:
 * 你可以使用原地算法解决本题吗？
 * 请注意，
 * 面板上所有格子需要同时被更新：
 * 你不能先更新某些格子，
 * 然后使用它们的更新后的值再更新其他格子。
 * 本题中，
 * 我们使用二维数组来表示面板。
 * 原则上，
 * 面板是无限的，
 * 但当活细胞侵占了面板边界时会造成问题。
 * 你将如何解决这些问题？
 */
public class GameOfLife_289 {
    private static void gameOfLife(int[][] board) {
        int[][] boardOld = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardOld[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = update(boardOld, i, j);
            }
        }
    }

    private static int update(int[][] boardOld, int i, int j) {
        int currentCellStatus = boardOld[i][j];
        int liveCellAroundCurrentCell = countAlive(boardOld, i, j);
        if (currentCellStatus == 1) {
            if (liveCellAroundCurrentCell < 2) {
                return 0;
            } else if (liveCellAroundCurrentCell == 2 || liveCellAroundCurrentCell == 3) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (liveCellAroundCurrentCell == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static int countAlive(int[][] boardOld, int i, int j) {
        return isAlive(i - 1, j - 1, boardOld) +
                isAlive(i - 1, j, boardOld) +
                isAlive(i + 1, j, boardOld) +
                isAlive(i, j - 1, boardOld) +
                isAlive(i, j + 1, boardOld) +
                isAlive(i + 1, j - 1, boardOld) +
                isAlive(i + 1, j, boardOld) +
                isAlive(i + 1, j + 1, boardOld);
    }

    private static int isAlive(int i, int j, int[][] boardOld) {
        if (i < 0 || i > boardOld.length - 1) {
            return 0;
        }
        if (j < 0 || j > boardOld[0].length - 1) {
            return 0;
        }
        return boardOld[i][j];
    }

    /**
     * 要死的为 2 要活的为 -1
     */
    private static void gameOfLife1(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //记录8个方位活细胞的数量
                int count = 0;
                //左上
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] > 0) {
                    count++;
                }
                //上方
                if (i - 1 >= 0 && board[i - 1][j] > 0) {
                    count++;
                }
                //右上
                if (i - 1 >= 0 && j + 1 < col && board[i - 1][j + 1] > 0) {
                    count++;
                }
                //左方
                if (j - 1 >= 0 && board[i][j - 1] > 0) {
                    count++;
                }
                //右方
                if (j + 1 < col && board[i][j + 1] > 0) {
                    count++;
                }
                //左下
                if (i + 1 < row && j - 1 >= 0 && board[i + 1][j - 1] > 0) {
                    count++;
                }
                //下方
                if (i + 1 < row && board[i + 1][j] > 0) {
                    count++;
                }
                //右下
                if (i + 1 < row && j + 1 < col && board[i + 1][j + 1] > 0) {
                    count++;
                }
                //现在是活细胞
                if (board[i][j] == 1) {
                    //将来是死细胞
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else {//现在是死细胞
                    if (count == 3) {
                        //将来能够复活
                        board[i][j] = -1;
                    }
                }
            }
        }
        //将2、-1换成对应的0,1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife1(board);
        System.out.println(Arrays.deepToString(board));
    }
}
