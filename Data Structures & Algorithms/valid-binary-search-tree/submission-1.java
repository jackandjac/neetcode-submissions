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
        return isValid(root,  null, null);
    }

    private boolean isValid(TreeNode node, Integer l, Integer r){
        if (node == null) {
            return true;
        }
        if ( (l != null && node.val <= l) || (r != null && node.val >= r)){
            return false;
        }

        return isValid(node.left, l, node.val) && isValid(node.right, node.val, r);
    }
}
