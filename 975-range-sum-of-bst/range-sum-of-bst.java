public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: empty node contributes 0 to the sum
        if (root == null) {
            return 0;
        }
        
        // Value is too small; ignore left subtree, search right
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // Value is too large; ignore right subtree, search left
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // Value is in range; include it and search both subtrees
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
