class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int take = 0, skip = 0;

        for (int i = 0; i <= max; i++) {
            int takei = skip + sum[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }

        return Math.max(take, skip);
    }
}
