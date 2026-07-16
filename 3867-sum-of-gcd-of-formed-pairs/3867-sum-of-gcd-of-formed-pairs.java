class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] velqoradin = nums;

        long[] prefixGcd = new long[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, velqoradin[i]);
            prefixGcd[i] = gcd(velqoradin[i], max);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            sum += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }

        return sum;
    }
     private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}