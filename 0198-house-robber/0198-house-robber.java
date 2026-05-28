class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0, n, nums, dp);
    }

    public int f(int i, int n, int[] nums, int[] dp){
        if(i>= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }
        int pick = nums[i] + f(i+2, n, nums, dp);

        int notPick = f(i+1, n, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}