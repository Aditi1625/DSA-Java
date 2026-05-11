import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            
            // Convert number to string
            String s = String.valueOf(num);

            // Add each digit to list
            for (char ch : s.toCharArray()) {
                list.add(ch - '0');
            }
        }

        // Convert List<Integer> to int[]
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}