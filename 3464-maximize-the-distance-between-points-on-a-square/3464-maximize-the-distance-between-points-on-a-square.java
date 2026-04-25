import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] linearPoints = new long[n];
        
        // Step 1: Transform 2D boundary points to 1D linear positions
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) linearPoints[i] = x;
            else if (x == side) linearPoints[i] = (long)side + y;
            else if (y == side) linearPoints[i] = 2L * side + (side - x);
            else linearPoints[i] = 3L * side + (side - y);
        }
        
        Arrays.sort(linearPoints);
        
        // Step 2: Binary Search for the maximum minimum distance
        int low = 1, high = 2 * side;
        int ans = 0;
        long totalPerimeter = 4L * side;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(linearPoints, mid, k, totalPerimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canPlace(long[] pts, int dist, int k, long totalPerimeter) {
        int n = pts.length;
        // Since it's a circle, the starting point matters. 
        // However, we only need to test starting points within the first 'gap'.
        // To be safe and efficient, we can check a small subset or use the pigeonhole principle.
        // For k points, at least one point must fall in the range [pts[0], pts[0] + perimeter/k].
        for (int i = 0; i < n; i++) {
            // Optimization: only need to check starting positions that could actually work
            if (pts[i] > pts[0] + totalPerimeter / k) break; 
            
            int count = 1;
            long lastPos = pts[i];
            long firstPos = pts[i];
            int currIdx = i;
            
            for (int j = 1; j < k; j++) {
                long target = lastPos + dist;
                // Find next point >= lastPos + dist
                int nextIdx = findNext(pts, target);
                
                if (nextIdx == -1) {
                    // Wrap around check
                    target -= totalPerimeter;
                    nextIdx = findNext(pts, target);
                }
                
                // If we wrapped around or can't find a point
                if (nextIdx == -1 || (nextIdx >= i && count > 0 && pts[nextIdx] >= firstPos)) {
                   // This logic is simplified by duplicating the array or using modulo
                }
            }
            // Simplified Greedy check for the circular constraint:
            if (checkFromStart(pts, i, dist, k, totalPerimeter)) return true;
        }
        return false;
    }

    private boolean checkFromStart(long[] pts, int startIdx, int dist, int k, long totalPerimeter) {
        int n = pts.length;
        int count = 1;
        int curr = startIdx;
        for (int i = 1; i < k; i++) {
            long target = pts[curr] + dist;
            // Binary search for the first point >= target
            int next = lowerBound(pts, target);
            if (next == n) return false; // Could not find k points linearly
            curr = next;
            count++;
        }
        // Final check: Distance between last point and the first point (wrapped)
        return (totalPerimeter - (pts[curr] - pts[startIdx])) >= dist;
    }

    private int lowerBound(long[] pts, long target) {
        int l = 0, r = pts.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (pts[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
    
    // Fallback for findNext logic used in pseudocode
    private int findNext(long[] pts, long target) {
        int idx = lowerBound(pts, target);
        return idx == pts.length ? -1 : idx;
    }
}