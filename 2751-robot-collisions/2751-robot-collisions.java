import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on their positions
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                // Robot is moving Left ('L'), handle collisions with 'R' robots in stack
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.peek();
                    
                    if (healths[currentIndex] > healths[topIndex]) {
                        // Left robot wins
                        healths[topIndex] = 0;
                        healths[currentIndex] -= 1;
                        stack.pop();
                    } else if (healths[currentIndex] < healths[topIndex]) {
                        // Right robot wins
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                    } else {
                        // Both destroyed
                        healths[topIndex] = 0;
                        healths[currentIndex] = 0;
                        stack.pop();
                    }
                }
            }
        }

        // Collect survivors in original order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}