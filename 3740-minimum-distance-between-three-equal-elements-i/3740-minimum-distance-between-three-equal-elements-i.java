class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int dis = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        found = true;
                        int curr = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        dis = Math.min(dis, curr);
                    }
                }
            }
        }
        return found ? dis : -1;
    }
}