class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = 0; // Reset for each call
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // 1. Visit left subtree
        inorder(root.left, k);

        // 2. Process current node
        count++;
        if (count == k) {
            result = root.val;
            return; // Found the result
        }

        // 3. Visit right subtree (only if not found yet)
        if (count < k) {
            inorder(root.right, k);
        }
    }
}