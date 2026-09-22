class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
      int ans = nums.length; // Default to n (agar saare elements target se chhote hon)

while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] >= target) {
        ans = mid;        // mid feasible candidate hai, par kya isse pehle koi aur hai?
        hi = mid - 1;     // Left side dhoondho
    } else {
        lo = mid + 1;     // nums[mid] chhota hai, right side jao
    }
}
return ans; // ya direct return lo;
    }
}