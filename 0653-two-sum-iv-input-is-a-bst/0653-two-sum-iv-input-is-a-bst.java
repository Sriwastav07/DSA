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
    ArrayList<Integer> ans = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root, ans);

        int n = ans.size();
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = ans.get(left) + ans.get(right);
            if(sum < k){
                left++;
            }
            else if(sum > k){
                right--;
            }
            else{
                return true;
            }

        }
        return false;
    }
    public void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}