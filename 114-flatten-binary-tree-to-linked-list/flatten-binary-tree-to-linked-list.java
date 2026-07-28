class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        
        while (current != null) {
            
            if (current.left != null) {
                
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                
                rightmost.right = current.right;
                
                
                current.right = current.left;
                current.left = null; 
            }
            
            
            current = current.right;
        }
    }
}
