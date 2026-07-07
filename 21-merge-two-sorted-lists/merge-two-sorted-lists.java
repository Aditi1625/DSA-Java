// 1. Ensure the class name is exactly "Solution"
class Solution {
    
    // 2. Your method must be inside this class
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Your logic goes here
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        
        return dummy.next;
    }
}
