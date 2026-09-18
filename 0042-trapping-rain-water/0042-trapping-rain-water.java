import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        Deque<Integer> stack = new ArrayDeque<>(); // stores indices
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            // Right wall mil gayi jo stack top se badi hai
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();

                // Agar left wall hi nahi hai to paani trap nahi ho sakta
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int distance = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[bottom];

                water += distance * boundedHeight;
            }

            stack.push(i);
        }

        return water;
    }
}