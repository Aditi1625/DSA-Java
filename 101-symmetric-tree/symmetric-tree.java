class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        
        // Compare t1's left child with t2's right child
        // AND t1's right child with t2's left child
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
