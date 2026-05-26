class Solution {
    public boolean isPowerOfTwo(int n) {
        // if(n<=0){
        //     return false;
        // }
        // int temp = n;
        // while(temp>1){
        //     if(temp %2 != 0){
        //         return false;
        //     }
        //     temp = temp/2;
        // }

        
        // return true;

        return (n>0) && ((n & (n-1)) == 0);
    }
}