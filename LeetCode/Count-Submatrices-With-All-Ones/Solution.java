class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length , m = mat[0].length;
        int[][] width = new int[n][m];
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) width[i][j] = (j == 0 ? 0 : width[i][j - 1]) + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minWidth = width[i][j];
                for (int k = i; k >= 0 && minWidth > 0; k--) {
                    minWidth = Math.min(minWidth , width[k][j]);
                    res += minWidth;
                }
            }
        }
        return res;
    }
}