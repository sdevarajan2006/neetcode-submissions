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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        java.util.ArrayList<Integer> leftIn = new java.util.ArrayList<>();

        // left inorder
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                break;
            }
            leftIn.add(inorder[i]);
        }
        int leftInSize = leftIn.size();

        // put in array
        int i = 0;
        int[] leftInorder = new int[leftInSize];
        while(i < leftInSize){
            leftInorder[i] = leftIn.get(i);
            i += 1;
        }

        /*
        System.out.println("left In-order traversal:");
        for(int a : leftInorder){
            System.out.println(a);
        }
        */
        
        
        // right Inorder
        int[] rightInorder = new int[preorder.length - leftInSize - 1];
        i += 1;
        while(i < inorder.length){
            rightInorder[i - leftInSize - 1] = inorder[i];
            i += 1;
        }

        /*
        System.out.println("right In-order traversal:");
        for(int a : rightInorder){
            System.out.println(a);
        }
        */

        // leftPreOrder
        int[] leftPreOrder = new int[leftInorder.length];
        for(int j = 0; j < leftInorder.length; j ++){
            leftPreOrder[j] = preorder[j + 1];
        }

        /*
        System.out.println("left Pre-order traversal:");
        for(int a : leftPreOrder){
            System.out.println(a);
        }
        */
        

        // right preorder
        int[] rightPreOrder = new int[rightInorder.length];
        for(int j = 0; j < rightInorder.length; j++){
            rightPreOrder[j] = preorder[j + leftInorder.length + 1];
        }

        /*
        System.out.println("right Pre-order traversal:");
        for(int a : rightPreOrder){
            System.out.println(a);
        }
        */

        root.right = buildTree(rightPreOrder,rightInorder);
        root.left = buildTree(leftPreOrder, leftInorder);

        return(root);

        



        
    }
}
