class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(calc(n1, n2, s));
            }
            else{
                st.push(Integer.valueOf(s));
            }
        }
        return st.peek();
    }

    public int calc(int n1, int n2, String s){
        if(s.equals("+")){
            return n2+n1;
        }
        else if(s.equals("-")){
            return n2-n1;
        }
        else if(s.equals("*")){
            return n2*n1;
        }

        return n2/n1;
    }
}