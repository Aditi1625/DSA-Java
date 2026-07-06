class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null, structural match
        if (p == null && q == null) {
            return true;
        }
        
        // One node is null or values do not match
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
