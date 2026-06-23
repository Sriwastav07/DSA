class Solution {
    public int divide(int dividend, int divisor) {
       if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
       }
       long a = Math.abs((long)dividend);
       long b = Math.abs((long)divisor);
       int result = 0;
       while(a >= b){
            int multiple = 0;
            while(a >= (b<<multiple)){
                multiple++;
            }

            multiple--;
            result += (1<<multiple);

            a -= (b<<multiple);
       }
       if((dividend<0) ^ (divisor<0)){
            return -(result);
       }
       return result;
    }
}