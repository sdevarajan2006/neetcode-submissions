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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int pValue = p.val; 
        int qValue = q.val;
        int smaller = Math.min(pValue, qValue);
        int larger = Math.max(pValue, qValue);
        int currVal;

        while (curr != null){
            currVal = curr.val;
            if (currVal == pValue || currVal == qValue){
                return(curr);
            }
            if(smaller < currVal && larger > currVal){
                return(curr);
            }
            if(smaller < currVal && larger < currVal){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        
            
        }
        return(null);
        
        
        
        

        
        
        
        
    }
}
