class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Continuously divide n by powers of 5 and add to count
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }
}