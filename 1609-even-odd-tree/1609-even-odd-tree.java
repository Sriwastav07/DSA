/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean evenLevel = true;
        while(!q.isEmpty()){
            int size = q.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode front = q.poll();
                int nodeVal = front.val;
                if(evenLevel && (nodeVal%2==0 || prev>=nodeVal)){
                    return false;
                }
                if(!evenLevel && (nodeVal%2!=0 || prev<=nodeVal)){
                    return false;
                }
                prev = nodeVal;
                if(front.left != null){
                    q.offer(front.left);
                }
                if(front.right != null){
                    q.offer(front.right);
                }
            }
            evenLevel = !evenLevel;
        } 

        return true;
    }
}