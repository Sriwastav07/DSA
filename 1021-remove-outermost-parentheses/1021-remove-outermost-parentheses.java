class Solution {
    public String removeOuterParentheses(String s) {
        // int cnt = 0;
        // StringBuilder sb = new StringBuilder();

        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);

        //     if(ch == '('){
        //         cnt++;
        //         if(cnt > 1){
        //             sb.append('(');
        //         }
        //     }
        //     else{
        //         cnt--;
        //         if(cnt > 0){
        //             sb.append(')');
        //         }
        //     }
        // }

        // return sb.toString();

        StringBuilder sb = new StringBuilder();

        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(!st.isEmpty()){
                    sb.append(ch);
                }
                st.push(ch);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}