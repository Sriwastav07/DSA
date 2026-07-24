class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        // for(int i=0;i<n;i++){
        //     pq.offer(nums[i]);
        // }
        // int m = 0;
        // while(m != n-k){
        //     pq.poll();
        //     m++;
        // }
        // return pq.peek();

        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();

    }
}