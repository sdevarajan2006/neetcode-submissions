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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = diameterHelper(root);
        return(max -2 );
        
        
        
    }

    public int diameterHelper(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDepth = 1 + diameterHelper(root.left);
        int rightDepth = 1 + diameterHelper(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return(Math.max(leftDepth, rightDepth));

    }
}
