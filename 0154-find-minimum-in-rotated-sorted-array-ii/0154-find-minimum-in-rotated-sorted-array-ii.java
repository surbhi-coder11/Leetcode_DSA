class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } 
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            else {
                // nums[mid] == nums[right], shrink right
                right--;
            }
        }

        return nums[left];
    }
}
