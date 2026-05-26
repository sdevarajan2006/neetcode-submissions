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
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if (((Math.max(leftHeight,rightHeight )) - (Math.min(leftHeight,rightHeight ))) > 1){
            return false;
        }
        return(isBalanced(root.left) && isBalanced(root.right));
        
    }
    public int helper(TreeNode root){
        if (root == null){
            return 0; 
        }
        int rightDepth = helper(root.right);
        int leftDepth = helper(root.left);
        return (1 + Math.max(rightDepth, leftDepth));
    }
}
