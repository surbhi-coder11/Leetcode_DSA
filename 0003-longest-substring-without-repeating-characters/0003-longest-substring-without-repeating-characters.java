class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128]; 
        // stores last occurrence of each char
        for (int i = 0; i < 128; i++) lastIndex[i] = -1;

        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character appeared before and is inside current window
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;   // shrink window
            }

            lastIndex[c] = right;         // update last seen index

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
