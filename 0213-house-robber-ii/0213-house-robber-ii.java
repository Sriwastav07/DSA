class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        if(n==1){
            return nums[0];
        }
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int j=0, k=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[j++] = nums[i]; 
            }

            if(i!=n-1){
                temp2[k++] = nums[i];
            }
        }

        return Math.max(f(temp1), f(temp2));
    }

    public int f(int[] arr){
        int n = arr.length;

        int prev = arr[0];
        int prev2 = 0;

        for(int i=1;i<n;i++){
            int pick = arr[i] + prev2;
            int notPick = prev;

            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}