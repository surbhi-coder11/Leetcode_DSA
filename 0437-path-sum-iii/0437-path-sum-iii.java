class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private int dfs(TreeNode node, long targetSum) {
        if (node == null) return 0;
        return countFrom(node, targetSum) 
             + dfs(node.left, targetSum) 
             + dfs(node.right, targetSum);
    }

    private int countFrom(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) count++;

        count += countFrom(node.left, targetSum - node.val);
        count += countFrom(node.right, targetSum - node.val);

        return count;
    }
}
