import java.util.*;
class Solution {
    public int reverse(int x) {
        long num=0;
        while(x != 0 ){
            int digit = x % 10;
            num=num*10 + digit;
            if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
            x= x/10;
        }
        return (int)num;
    }
}
