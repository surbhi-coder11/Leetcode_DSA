import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int x = 0, y = 0, d = 0;
        int maxDistSq = 0;
        
        for (int cmd : commands) {
            if (cmd == -1) { 
                d = (d + 1) % 4;
            } else if (cmd == -2) { // Turn left
                d = (d + 3) % 4;
            } else { 
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dx[d];
                    int nextY = y + dy[d];
                    
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return maxDistSq;
    }
}