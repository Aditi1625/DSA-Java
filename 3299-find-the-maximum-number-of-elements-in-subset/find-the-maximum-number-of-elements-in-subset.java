import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long)x, map.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, cnt % 2 == 0 ? cnt - 1 : cnt);
        }

        for (long x : map.keySet()) {

            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (true) {

                int cnt = map.getOrDefault(cur, 0);

                if (cnt >= 2) {
                    len += 2;

                    if (cur * cur > 1000000000000000000L) {
                        len--;
                        break;
                    }

                    cur *= cur;
                } else if (cnt == 1) {
                    len++;
                    break;
                } else {
                    if (len > 0) len--;
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}