class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int components;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ)
                return;
            if (size[rootI] <= size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
            components --;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }
    public int latestDayToCross(int m, int n, int[][] cells) {
        int[][] end = new int[m][n];
        for (int[] rows : end) {
            Arrays.fill(rows, 0);
        }
        
        for (int[] cell : cells) {
            end[cell[0]-1][cell[1]-1] = 1;
        }
        
        UnionFind uf = new UnionFind(m * n + 2);
        int top = m * n, bot = m * n + 1;
        for (int j = 0; j < n; ++j) {
            if (end[0][j] == 0) 
                uf.union(j, top);
            if (end[m-1][j] == 0)
                uf.union((m-1) * n + j, bot);
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (end[i][j] == 0) {
                    if (i > 0 && end[i-1][j] == 0) {
                        uf.union(i*n+j, (i-1)*n+j);
                    }
                    if (j > 0 && end[i][j-1] == 0) {
                        uf.union(i*n+j, i*n+j-1);
                    }
                }
            }
        }
        
        for (int i = cells.length - 1; i >= 0; --i) {
            if (uf.connected(top, bot))
                return i + 1;
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            end[r][c] = 0;
            if (r == 0)
                uf.union(top, r*n + c);
            if (r == m - 1)
                uf.union(bot, r*n + c);
            int[] dirs = new int[]{-1, 0, 1, 0, -1};
            for (int k = 0; k < 4; ++k) {
                int nr = r + dirs[k], nc = c + dirs[k+1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && end[nr][nc] == 0) {
                    uf.union(r*n+c, nr*n+nc);
                }
            }
        }
        
        return 0;
    }
}