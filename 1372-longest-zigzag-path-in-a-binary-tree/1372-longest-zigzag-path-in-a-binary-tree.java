class Solution {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return max;
    }

    private void dfs(TreeNode node, int length, boolean left) {
        if (node == null) return;

        max = Math.max(max, length);

        if (left) {
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);
        } else {
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);
        }
    }
}
