class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int [] nums, int k){
        int n = nums.length;

        int i=0;
        int j=0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(j < n){
            int val = nums[j];

            map.put(val, map.getOrDefault(val, 0)+1);

            while(map.size() > k){
                int left = nums[i];
                map.put(left, map.get(left)-1);

                if(map.get(left) == 0){
                    map.remove(left);
                }
                
                i++;
            }

            
            ans += j-i+1;

            j++;
        }

        return ans;
    }
}