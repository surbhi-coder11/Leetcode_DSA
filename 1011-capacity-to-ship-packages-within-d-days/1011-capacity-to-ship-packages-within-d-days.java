class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int current = 0;
        int requiredDays = 1;

        for (int w : weights) {
            if (current + w > capacity) {
                requiredDays++;
                current = 0;
            }
            current += w;
        }

        return requiredDays <= days;
    }
}
