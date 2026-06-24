class Solution {
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        int res = start ^ goal;

        while(res > 1){
            cnt += (res & 1);
            res = res>>1;
        }

        if(res == 1){
            cnt++;
        }

        return cnt;
    }
}