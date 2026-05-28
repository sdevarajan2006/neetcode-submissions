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

public class Codec {
    int pointer = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "N";
        }
        int rootval = root.val;
        String stringVal = String.valueOf(rootval);

        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        return(stringVal + "," + leftString + "," + rightString);

        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        TreeNode ans = helper(parts);
        return(ans);

        
    }

    public TreeNode helper(String[] d){
        String datum = d[pointer];
        

        pointer += 1;
        if(datum.equals("N")){
            return null;
        }
        int intdatum = Integer.parseInt(datum);

        TreeNode tn = new TreeNode(intdatum);

        tn.left = helper(d);
        tn.right = helper(d);

        return(tn);

    }
}
