class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // If root value is in range, include it and check both subtrees
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }

        // If root value is smaller than low, target nodes can only be in right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If root value is larger than high, target nodes can only be in left subtree
        return rangeSumBST(root.left, low, high);
    }
}