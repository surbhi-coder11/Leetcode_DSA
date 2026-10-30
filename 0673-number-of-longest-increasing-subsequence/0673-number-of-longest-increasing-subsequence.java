class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] len = new int[n];
        int[] count = new int[n];
        
        // Every element is an increasing subsequence of length 1 by itself, with 1 way.
        java.util.Arrays.fill(len, 1);
        java.util.Arrays.fill(count, 1);

        int maxLen = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j]; // Reset count to the previous path count
                    } else if (len[j] + 1 == len[i]) {
                        count[i] += count[j]; // Accumulate paths of the same length
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        // Sum up all counts that match the global max length
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }
}