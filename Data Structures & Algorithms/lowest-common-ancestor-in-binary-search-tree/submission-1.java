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
    TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return node;
    }

    private int lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int val = (root.val == p.val || root.val == q.val) ? 1: 0;
        int left = lca(root.left, p, q);
        int right = lca(root.right, p, q);
        if (val + left + right >= 2) {
            node = root;
        }
        return val + left + right >= 1 ? 1: 0;

    }
}
