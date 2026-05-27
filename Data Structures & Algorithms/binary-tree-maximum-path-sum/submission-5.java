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
    int max = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        int i = helper(root);
        return max;
         


        
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;

        int rightMax = helper(rightChild);
        int leftMax = helper(leftChild);

        max = Math.max(max, root.val + rightMax + leftMax);
        max = Math.max(max, root.val + rightMax);
        max = Math.max(max, root.val + leftMax);
        max = Math.max(max, root.val);

        return(Math.max(Math.max(root.val + rightMax, root.val + leftMax), root.val));

    }
}
