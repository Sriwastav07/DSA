// class Solution {
//     public int uniquePathsWithObstacles(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;

//         int[][] dp = new int[n][m];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         return f(n-1,m-1, dp, grid);
//     }

//     public int f(int n, int m, int[][] dp, int[][] grid){
//         if(n==0 && m==0 && grid[n][m] != 1){
//             return 1;
//         }

//         if(grid[n][m] == 1){
//             return 0;
//         }

//         if(dp[n][m] != -1){
//             return dp[n][m];
//         }

//         int up = 0;
//         int left = 0;
//         if(n > 0){
//             up = f(n-1, m, dp, grid);
//         }

//         if(m> 0){
//             left = f(n, m-1, dp, grid);
//         }

//         return dp[n][m] = up+left;
//     }
// }


class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for(int i=0;i<n;i++){
            int[] temp = new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && grid[i][j]!=1){
                    temp[j] = 1;
                    continue;
                }

                if(grid[i][j] == 1){
                    temp[j] = 0;
                    continue;
                }

                int up = 0;
                int left = 0;
                if(i>0){
                    up = prev[j];
                }

                if(j>0){
                    left = temp[j-1];
                }

                temp[j] = up+left;
            }
            prev = temp;
        }

        return prev[m-1];
    }

}