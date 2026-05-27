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
    java.util.ArrayList<Integer> ans = new java.util.ArrayList<>(); 
    java.util.HashSet<Integer> layersDone = new java.util.HashSet<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return(ans);


        
    }

    public void helper(TreeNode root, int currLevel){
        if (root == null){
            return;
        }
        if (!layersDone.contains(currLevel)){
            layersDone.add(currLevel);
            ans.add(root.val);
        }
        helper(root.right, currLevel + 1);
        helper(root.left, currLevel + 1);


    }



}
