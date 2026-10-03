class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Path via current node = leftHeight + rightHeight (edges count)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Height return karne ke liye +1 add karo
        return Math.max(leftHeight, rightHeight) + 1;
    }
}