class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                if(i==0 && j==0){
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                int down = Integer.MAX_VALUE;
                int diag = Integer.MAX_VALUE;
                if(j<i){
                    down = triangle.get(i).get(j) + dp[i-1][j];
                }

                if(j>0){
                    diag = triangle.get(i).get(j) + dp[i-1][j-1];
                }
                
                dp[i][j] = Math.min(down, diag);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}