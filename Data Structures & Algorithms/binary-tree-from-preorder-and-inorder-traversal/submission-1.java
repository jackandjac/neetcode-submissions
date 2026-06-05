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
    private int[] preorder;
    private Map<Integer, Integer> inMap = new HashMap<>();
    private int pIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildNode(0, inorder.length);

    }

    private TreeNode buildNode(int l , int r) {
        if (l == r){
            return null;
        }
        int val = preorder[pIdx++];
        int idx = inMap.get(val);

        TreeNode node = new TreeNode(val);
        node.left = buildNode(l, idx);
        node.right = buildNode(idx +1, r);
        return node;
    }
}
