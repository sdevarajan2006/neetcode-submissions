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
    java.util.HashMap<Integer, Integer> indices = new java.util.HashMap<>();
    int counter = 1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return(indices.get(k));

        
    }

    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        indices.put(counter, root.val);
        counter += 1;
        helper(root.right);
    }
}
