import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        long remBudget = budget;
        long minPrice = Long.MAX_VALUE;

        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // Precompute sum of freq[mult] for each distinct factor f in O(N log N) total
        int[] multSum = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) {
                continue;
            }
            int sum = 0;
            for (int mult = f; mult <= n; mult += f) {
                sum += freq[mult];
            }
            multSum[f] = sum;
        }

        // Pack (price << 32) | gain into a primitive long[] to avoid object boxing
        long[] packed = new long[n];
        for (int i = 0; i < n; i++) {
            long price = items[i][1];
            long gain = multSum[items[i][0]] - 1L;
            packed[i] = (price << 32) | gain;
        }
        Arrays.sort(packed);

        long totalItems = 0;
        long limitPrice = 2 * minPrice;

        // Only buy value-2 units if cheaper per item than 2 value-1 units of minPrice
        for (long entry : packed) {
            long price = entry >>> 32;
            if (price >= limitPrice) {
                break;
            }
            long boostedCopies = entry & 0xFFFFFFFFL;
            if (boostedCopies <= 0 || remBudget < price) {
                continue;
            }
            long take = Math.min(boostedCopies, remBudget / price);
            totalItems += take * 2;
            remBudget -= take * price;
        }

        // Spend remaining budget on value-1 copies using the cheapest item overall
        if (remBudget >= minPrice) {
            totalItems += remBudget / minPrice;
        }

        return (int) totalItems;
    }
}