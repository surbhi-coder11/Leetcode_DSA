class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) left = mid + 1;
                else right = mid;
            }
            dp[left] = num;
            if (left == size) size++;
        }

        return size;
    }
}
