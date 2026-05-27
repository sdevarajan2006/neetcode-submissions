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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    
        
    }

    public boolean helper(TreeNode root, int gt, int lt){
        if (root == null){
            return true;
        }
        int val = root.val;
        if (!(val > gt && val < lt)){
            return false;
        }
        int rightgt = root.val;
        int rightlt = lt;

        int leftgt = gt;
        int leftlt = root.val;

        return (helper(root.right, rightgt, rightlt) &&
                helper(root.left, leftgt, leftlt));
    }

     
}
