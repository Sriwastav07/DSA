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
    int idx;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        idx = n-1;
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, n-1);
    }

    public TreeNode helper(int[] postorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.right = helper(postorder, mid + 1, right);
        root.left = helper(postorder, left, mid - 1);

        return root;
    }

}