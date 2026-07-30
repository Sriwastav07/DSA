class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, findLargest(heights));
        }
        return maxArea;
    }

    public int findLargest(int[] heights){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        int[] newHeight = Arrays.copyOf(heights, heights.length+1);

        for(int i=0;i<newHeight.length;i++){
            while(!st.isEmpty() && newHeight[i] < newHeight[st.peek()]){
                int height = newHeight[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                maxArea = Math.max(maxArea, width*height);
            }
            st.push(i);
        }
        
        return maxArea;
    }
}