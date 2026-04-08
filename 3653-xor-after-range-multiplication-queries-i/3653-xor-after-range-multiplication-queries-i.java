class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        int n = nums.length;

        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            long v = query[3];

            // Update elements from l to r with step k
            for (int idx = l; idx <= r; idx += k) {
                long updatedValue = (nums[idx] * v) % MOD;
                nums[idx] = (int) updatedValue;
            }
        }

        // Calculate the XOR sum of the final array
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        return xorSum;
    }
}