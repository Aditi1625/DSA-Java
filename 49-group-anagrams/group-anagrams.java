import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Step 1: sort the string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Step 2: store in map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        // Step 3: return result
        return new ArrayList<>(map.values());
    }
}