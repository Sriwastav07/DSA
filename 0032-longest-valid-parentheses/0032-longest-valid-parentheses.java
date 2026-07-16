class Solution {
    public int longestValidParentheses(String s) {
        // Stack<Integer> stk = new Stack<>();
        // int maxLen = 0;
        // int invalid = -1;
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(ch == '('){
        //         stk.push(i);
        //     }
        //     else{
        //         if(stk.isEmpty()){
        //             invalid = i;
        //         }
        //         else{
        //             stk.pop();

        //             if(stk.isEmpty()){
        //                 maxLen = Math.max(maxLen, i - invalid);
        //             }
        //             else{
        //                 maxLen = Math.max(maxLen, i - stk.peek());
        //             }
        //         }
        //     }
        // }
        // return maxLen;

        int n = s.length();

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxLen = Math.max(maxLen, i-st.peek());
                }
            }
        }

        return maxLen;
    }
}