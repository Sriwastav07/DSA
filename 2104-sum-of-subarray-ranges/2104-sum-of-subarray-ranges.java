class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubArrayMax(nums) - sumSubArrayMin(nums);
    }

    public long sumSubArrayMax(int[] nums){
        int[] nxt = nxtG(nums);
        int[] prev = prevG(nums);

        long sum = 0;

        for(int i=0;i<nums.length;i++){
            int left = i - prev[i];
            int right = nxt[i] - i;

            long cnt = left * right * 1L;

            long total = cnt*nums[i];
            sum += total;
        }

        return sum;
    }

    public int[] nxtG(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int[] prevG(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    public long sumSubArrayMin(int[] nums){
        int[] nxt = nxtS(nums);
        int[] prev = prevS(nums);

        long sum = 0;

        for(int i=0;i<nums.length;i++){
            int left = i - prev[i];
            int right = nxt[i] - i;

            long cnt = left * right * 1L;

            long total = cnt*nums[i];
            sum += total;
        }

        return sum;
    }

    public int[] nxtS(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int[] prevS(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

}