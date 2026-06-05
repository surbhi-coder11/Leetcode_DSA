import java.util.Arrays;

class Solution {
    // 4D memoization table: [index][is_started][prev_digit][prev_prev_digit]
    private long[][][][] dp;
    private int[] digits;

    public long totalWaviness(long num1, long num2) {
        return countWaviness(num2) - countWaviness(num1 - 1);
    }

    private long countWaviness(long n) {
        if (n <= 0) return 0;
        
        // Convert number to digit array
        String s = Long.toString(n);
        int len = s.length();
        digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Initialize memoization array with -1
        dp = new long[len][2][11][11];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        // State variables: index, isLimit, isStarted, prevDigit, prevPrevDigit
        // 10 is used as a placeholder for unassigned digits (null/empty state)
        return dfs(0, true, false, 10, 10);
    }

    private long dfs(int index, boolean isLimit, boolean isStarted, int prev, int prevPrev) {
        // Base case: if reached the end, no more peaks/valleys can be formed
        if (index == digits.length) {
            return 0;
        }

        // Return memoized result if available (only when not restricted by the prefix limit)
        int startedIdx = isStarted ? 1 : 0;
        if (!isLimit && dp[index][startedIdx][prev][prevPrev] != -1) {
            return dp[index][startedIdx][prev][prevPrev];
        }

        int maxDigit = isLimit ? digits[index] : 9;
        long totalWaviness = 0;

        for (int d = 0; d <= maxDigit; d++) {
            boolean nextLimit = isLimit && (d == maxDigit);
            
            if (!isStarted && d == 0) {
                // Leading zero: skip processing and stay unstarted
                totalWaviness += dfs(index + 1, nextLimit, false, 10, 10);
            } else {
                long currentContribution = 0;
                
                // We can only check for a peak or valley if we have at least 2 previous real digits
                if (isStarted && prev != 10 && prevPrev != 10) {
                    // Check if 'prev' is a peak (strictly greater than neighbors)
                    boolean isPeak = (prev > prevPrev) && (prev > d);
                    // Check if 'prev' is a valley (strictly less than neighbors)
                    boolean isValley = (prev < prevPrev) && (prev < d);
                    
                    if (isPeak || isValley) {
                        // If 'prev' is a valid inflection point, it contributes 1 point 
                        // to every valid complete number suffix generated down this path.
                        currentContribution = countNumbers(index + 1, nextLimit);
                    }
                }
                
                // Accumulate waviness points from current position and recurse
                totalWaviness += currentContribution + dfs(index + 1, nextLimit, true, d, prev);
            }
        }

        if (!isLimit) {
            dp[index][startedIdx][prev][prevPrev] = totalWaviness;
        }
        return totalWaviness;
    }

    // Helper method to count how many valid numbers can be formed from the current suffix
    private long countNumbers(int index, boolean isLimit) {
        if (index == digits.length) return 1;
        if (!isLimit) {
            // Standard optimization: remaining matching combinations without constraints is 10^(remaining_length)
            long ans = 1;
            for (int i = index; i < digits.length; i++) {
                ans *= 10;
            }
            return ans;
        }
        
        long count = 0;
        int maxDigit = digits[index];
        for (int d = 0; d <= maxDigit; d++) {
            count += countNumbers(index + 1, isLimit && (d == maxDigit));
        }
        return count;
    }
}
