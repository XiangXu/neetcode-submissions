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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        traversalHelper(result, 0, root);
        return result;
    }

    private void traversalHelper(List<List<Integer>> result, int height, TreeNode node) {
        if(node == null) {
            return;
        }

        if(result.size() == height) {
            result.add(new ArrayList());
        }

        result.get(height).add(node.val);
        traversalHelper(result, height + 1, node.left);
        traversalHelper(result, height + 1, node.right);
    }
}
