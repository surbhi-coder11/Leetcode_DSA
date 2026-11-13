import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans = 0;
        long cost = 0;
        // Store indices of nums with nums[i] in non-increasing order.
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = nums.length - 1, j = nums.length - 1; i >= 0; --i) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                int l = dq.pollLast();
                int r = dq.isEmpty() ? j + 1 : dq.peekLast();
                // Adjust elements to maintain non-decreasing order property
                cost += (long) (r - l) * (nums[i] - nums[l]);
            }
            dq.offerLast(i);
            
            // Shrink the window from the right if the cost exceeds k
            while (cost > k) {
                cost -= (long) nums[dq.peekFirst()] - nums[j];
                if (dq.peekFirst() == j) {
                    dq.pollFirst();
                }
                --j;
            }
            
            ans += j - i + 1;
        }
        
        return ans;
    }
}