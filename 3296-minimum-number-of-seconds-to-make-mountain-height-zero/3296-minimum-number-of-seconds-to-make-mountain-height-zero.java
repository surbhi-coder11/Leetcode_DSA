class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0, right = (long)1e18;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canReduce(long time, int h, int[] workers) {
        long total = 0;

        for (int t : workers) {
            long val = (2 * time) / t;
            long x = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);
            total += x;
            if (total >= h) return true;
        }

        return false;
    }
}
