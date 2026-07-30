class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node curr = root;
        
        
        while (curr != null && curr.left != null) {
            Node head = curr;
            
            
            while (head != null) {
                
                head.left.next = head.right;
                
                
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                
                head = head.next;
            }
            
            
            curr = curr.left;
        }
        
        return root;
    }
}
