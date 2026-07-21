class Solution {
    public int[] asteroidCollision(int[] ast) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        int n = ast.length;

        for(int i=0;i<n;i++){
            boolean distroyed = false;
            while(!st.isEmpty() && st.peek() > 0  && ast[i]<0){
                if(st.peek() < -ast[i]){
                    st.pop();
                }
                else if(st.peek() == -ast[i]){
                    st.pop();
                    distroyed = true;
                    break;
                }
                else{
                    distroyed = true;
                    break;
                }
            }

            if(!distroyed){
                st.push(ast[i]);
            }
        }


        int m = st.size();
        int[] res = new int[m];
        for(int i=m-1;i>=0;i--){
            res[i] = st.pop();
        }

        return res;
    }
}