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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int val = node.val;
        int left = Math.max(0, maxSum(node.left) );
        int right = Math.max(0, maxSum(node.right));
        max = Math.max(max, val + left + right);

        return Math.max(left, right) + val;
    }
}
