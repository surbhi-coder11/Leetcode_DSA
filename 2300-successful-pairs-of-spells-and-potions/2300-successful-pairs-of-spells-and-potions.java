import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            long required = (success + spells[i] - 1) / spells[i];
            int left = 0, right = m - 1, index = m;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (potions[mid] >= required) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = m - index;
        }

        return result;
    }
}
