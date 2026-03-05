class Solution {
    public int minOperations(String s) {
        int change1 = 0; // pattern starting with '0'
        int change2 = 0; // pattern starting with '1'

        for (int i = 0; i < s.length(); i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected1) change1++;
            if (s.charAt(i) != expected2) change2++;
        }

        return Math.min(change1, change2);
    }
}
