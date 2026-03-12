class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            freq[r]++;
        }

        int x = 0;
        while (true) {
            int r = x % value;
            if (freq[r] == 0) return x;
            freq[r]--;
            x++;
        }
    }
}
