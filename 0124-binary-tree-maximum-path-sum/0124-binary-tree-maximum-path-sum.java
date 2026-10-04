class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore paths with negative sums by taking Math.max(0, ...)
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Price of a new path with 'node' as the highest node/split point
        int priceNewPath = node.val + leftGain + rightGain;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, priceNewPath);

        // Return the max gain if continuing the path through the parent
        return node.val + Math.max(leftGain, rightGain);
    }
}