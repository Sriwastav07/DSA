class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        int n = nums.length;
        int i=0;
        int j=0;
        int cnt=0;
        int odd=0;
        while(j < n){
            if(nums[j]%2!=0){
                odd++;
            }

            while(odd > k){
                if(nums[i]%2!=0){
                    odd--;
                }
                i++;
            }

            cnt += j-i+1;

            j++;
        }

        return cnt;
    }
}