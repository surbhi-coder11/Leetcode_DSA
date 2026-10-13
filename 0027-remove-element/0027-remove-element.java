class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // slow pointer

        for (int j = 0; j < nums.length; j++) { // fast pointer
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // new length
    }
}
