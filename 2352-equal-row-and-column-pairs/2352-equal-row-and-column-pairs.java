import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        
        // Store rows
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append(",");
            }
            String rowStr = row.toString();
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
        }
        
        int count = 0;
        
        // Compare columns
        for (int j = 0; j < n; j++) {
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < n; i++) {
                col.append(grid[i][j]).append(",");
            }
            String colStr = col.toString();
            count += map.getOrDefault(colStr, 0);
        }
        
        return count;
    }
}
