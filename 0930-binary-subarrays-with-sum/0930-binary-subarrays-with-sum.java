class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return atMost(nums, goal) - atMost(nums, goal-1);
    }

    public int atMost(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int cnt = 0;
        int sum = 0;
        int j = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            while(sum > goal){
                sum -= nums[j];
                j++;
            }

            cnt += i-j+1;
        }

        return cnt;
    }
}