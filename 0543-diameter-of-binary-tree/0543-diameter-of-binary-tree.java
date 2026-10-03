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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int hl = height(root.left);
        int hr = height(root.right);

        return Math.max(Math.max(left,right),hl+hr);
    }
}