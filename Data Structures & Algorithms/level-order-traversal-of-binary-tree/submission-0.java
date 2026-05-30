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
        List<List<Integer>> result = new ArrayList<>();
        deepFirstSearch(root, 0, result);
        return result;
    }

    private void deepFirstSearch(TreeNode node, int depth, List<List<Integer>> result) {
        if(node == null) {
            return;
        }

        if(result.size() == depth) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.val);
        deepFirstSearch(node.left, depth + 1, result);
        deepFirstSearch(node.right, depth + 1, result);
    }
}
