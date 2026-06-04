class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0); // dummy node
        ListNode temp = head;

        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {

            int num1 = 0;
            int num2 = 0;

            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int total = num1 + num2 + carry;

            carry = total / 10;      // carry for next digit
            int digit = total % 10;  // current digit

            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return head.next;
    }
}