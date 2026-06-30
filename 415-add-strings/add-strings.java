class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // Loop as long as there are digits to process or a carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            // Convert character to integer using ASCII math ('0' is 48)
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            // Calculate total sum for the current column
            int currentSum = digit1 + digit2 + carry;
            carry = currentSum / 10;        // Determine new carry
            res.append(currentSum % 10);    // Append the last digit of the sum

            // Move pointers left
            i--;
            j--;
        }

        // The digits were added in reverse order, so reverse before returning
        return res.reverse().toString();
    }
}
