import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code,
                                        String[] businessLine,
                                        boolean[] isActive) {

        // Business line order
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<Coupon> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            // Check active
            if (!isActive[i]) continue;

            // Check valid business line
            if (!order.containsKey(businessLine[i])) continue;

            // Check valid code
            if (code[i] == null || code[i].isEmpty()) continue;

            boolean validCode = true;

            for (char ch : code[i].toCharArray()) {
                if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                    validCode = false;
                    break;
                }
            }

            if (validCode) {
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        // Sort by businessLine order, then lexicographically by code
        Collections.sort(validCoupons, (a, b) -> {
            int cmp = Integer.compare(order.get(a.businessLine),
                                      order.get(b.businessLine));

            if (cmp != 0) return cmp;

            return a.code.compareTo(b.code);
        });

        // Extract result
        List<String> result = new ArrayList<>();

        for (Coupon c : validCoupons) {
            result.add(c.code);
        }

        return result;
    }

    // Helper class
    class Coupon {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}