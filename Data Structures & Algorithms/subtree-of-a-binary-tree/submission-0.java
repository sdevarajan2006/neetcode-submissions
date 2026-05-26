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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // traverse through root until root.val and subroot.val are the same. if same then return true
        
        java.util.Queue<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while(q.size() != 0){
            TreeNode removed = q.poll();
            if (removed.val == subRoot.val){
                if (isSameTree(removed, subRoot)){
                    return true;
                }
            }
            if (removed.left != null){
                q.add(removed.left);
            }
            if(removed.right != null){
                q.add(removed.right);
            }
        }
        return false;



    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return(isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
        
    }
}
