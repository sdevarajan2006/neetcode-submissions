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
    
    java.util.HashMap<Integer, List<Integer>> levels = new java.util.HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        java.util.ArrayList<List<Integer>> ans = new java.util.ArrayList<>();
        int i = 0; 
        while(levels.containsKey(i)){
            List<Integer> levelStuff = levels.get(i);
            ans.add(levelStuff);
            i += 1;
        }
        return(ans);


        
    }
    public void helper(TreeNode curr, int currLevel){
        if (curr == null){
            return;
        }
        if (levels.containsKey(currLevel)){
            levels.get(currLevel).add(curr.val);
        }
        else{
            java.util.ArrayList<Integer> al = new java.util.ArrayList<>();
            al.add(curr.val);
            levels.put(currLevel, al);
        }
        helper(curr.left, currLevel + 1);
        helper(curr.right, currLevel + 1);

    }

}
