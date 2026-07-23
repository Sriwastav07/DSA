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
// class Solution {
//     ArrayList<Integer> ans = new ArrayList<>();
//     public int kthSmallest(TreeNode root, int k) {
//         inOrder(root);
//         return ans.get(k-1);
//     }

//     public void inOrder(TreeNode root){
//         if(root == null){
//             return;
//         }

//         inOrder(root.left);
//         ans.add(root.val);
//         inOrder(root.right);
//     }
// }

class Solution {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    private int inorder(TreeNode root, int k) {
        if (root == null)
            return -1;

        int left = inorder(root.left, k);
        if (left != -1)
            return left;

        count++;
        if (count == k)
            return root.val;

        return inorder(root.right, k);
    }
}