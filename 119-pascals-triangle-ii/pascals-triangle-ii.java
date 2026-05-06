import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        long value = 1;  // first element is always 1
        row.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            value = value * (rowIndex - i + 1) / i;
            row.add((int)value);
        }
        
        return row;
    }
}