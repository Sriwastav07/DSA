class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
       
        int sum = Arrays.stream(cardPoints).sum();

        int leftSum=0;
        int rightSum=0;

        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int lastIdx = n-1;
        for(int i=k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[lastIdx--];

            maxSum = Math.max(maxSum, leftSum+rightSum);
        }

        return maxSum;
    }
}