class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at the
        // previous index whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;

            long[] next = new long[k];

            // Start a new subarray with only num
            next[mod]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newRem = (int) ((long) r * mod % k);
                next[newRem] += dp[r];
            }

            // Add all subarrays ending here to answer
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}