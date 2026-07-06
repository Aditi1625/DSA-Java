class Solution {
    public boolean isBalanced(TreeNode root) {
        // A helper return value of -1 indicates the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // Base case: an empty tree has a height of 0
        if (node == null) {
            return 0;
        }

        // Check if the left subtree is balanced
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Pass the unbalanced signal up
        }

        // Check if the right subtree is balanced
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Pass the unbalanced signal up
        }

        // If the current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // If balanced, return the actual height of this subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
