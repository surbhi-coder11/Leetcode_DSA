class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n];
        long[] product = new long[n];
        for(int i = 0; i<n; i++){
            sum[i] = nums[i];
        }

        for(int i = 1; i<n; i++){
            sum[i] += sum[i-1];
        }

        product[n-1] = 1;
        long totalSum = sum[n-1];
        for(int i = n-2; i>=0; i--){
            long next = nums[i+1] * product[i+1];
            if(next>totalSum) next = totalSum + 1;
            product[i] = next;
        }

        for(int i = 0; i<n; i++){
            if(product[i] == 0) return -1;
            if(sum[i] - nums[i] == product[i]) return i;
        }

        return -1;
    }
}