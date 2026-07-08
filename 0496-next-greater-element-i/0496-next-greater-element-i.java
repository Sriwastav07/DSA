class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int j=m-1;j>=0;j--){
            while(!st.isEmpty() && nums2[j] >= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                map.put(nums2[j], -1);
            }
            else{
                map.put(nums2[j], st.peek());
            }

            st.push(nums2[j]);
        }
        
        for(int i=0;i<n;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}