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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return ser(root, new StringBuilder());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>(Arrays.asList(data.split(",")));
        return dser(nodes);
    }

    private String ser(TreeNode node, StringBuilder str) {
        if (node == null) {
            str.append("null").append(",");
            return str.toString();
        }
        str.append(node.val).append(',');
        ser(node.left, str);
        ser(node.right,str);
        return str.toString();
    }

    private TreeNode dser(List<String> nodes) {
        if (nodes.get(0).equals("null")) {
            nodes.remove(0);
            return null;
        }

        int val = Integer.valueOf(nodes.get(0));
        nodes.remove(0);
        TreeNode node = new TreeNode(val);
        node.left = dser(nodes);
        node.right = dser(nodes);
        return node;
    }
    
}
