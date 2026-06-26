import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int index, int value) {
            while (index <= n) {
                bit[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        ArrayList<Integer> values = new ArrayList<>();
        for (int x : sorted) {
            if (values.isEmpty() || values.get(values.size() - 1) != x) {
                values.add(x);
            }
        }

        Fenwick bit = new Fenwick(values.size());

        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(values, x) + 1;
            ans += bit.query(idx - 1);
            bit.update(idx, 1);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}