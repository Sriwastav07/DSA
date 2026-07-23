class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] pse = prevS(heights, n);
        int[] nse = nxtS(heights, n);

        int maxArea = 0;

        for(int i=0;i<n;i++){
            int area = heights[i] * (nse[i] -pse[i] - 1); 
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] prevS(int[] h, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nxtS(int[] h, int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }
}