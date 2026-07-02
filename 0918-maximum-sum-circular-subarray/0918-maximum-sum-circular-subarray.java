class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = Arrays.stream(nums).sum();
        int curMax = 0;
        int curMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int num : nums){
            curMax += num;
            curMin += num;
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(minSum, curMin);

            if(curMax < 0){
                curMax = 0;
            }

            if(curMin > 0){
                curMin = 0;
            }
        }

        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, (total-minSum));
    }
}