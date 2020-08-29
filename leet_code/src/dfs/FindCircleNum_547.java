package dfs;

/**
 * @author jianglei
 * @date 2020/8/28 23:22
 * <p>
 * 题号：#547. 朋友圈
 * <p>
 * 班上有 N 名学生。
 * 其中有些人是朋友，
 * 有些则不是。
 * 他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，
 * 表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，
 * 表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1：
 * 输入：
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，
 * 学生 1 和学生 2 互为朋友，
 * 所以学生 0 和学生 2 也是朋友，
 * 所以他们三个在一个朋友圈，返回 1 。
 * <p>
 * 提示：
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 */
public class FindCircleNum_547 {
    //深度优先搜索
    public static int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     * 并查集：三大特征
     * 1、查找
     * 2、比较连通性
     * 3、合并
     */
    static class UF {
        private int count;
        private int[] parent;
        private int[] size;

        public UF(int count) {
            this.count = count;
            size = new int[count];
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }
    }

    public static int findCircleNum2(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        int[][] M1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int circleNum1 = findCircleNum2(M1);
        System.out.println(circleNum1);

        int[][] M2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int circleNum2 = findCircleNum2(M2);
        System.out.println(circleNum2);
    }
}
