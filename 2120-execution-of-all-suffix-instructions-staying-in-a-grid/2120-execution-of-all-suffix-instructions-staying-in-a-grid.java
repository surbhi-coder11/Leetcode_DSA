class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] result = new int[m];

        // Iterate through each starting instruction index i
        for (int i = 0; i < m; i++) {
            int count = 0;
            int currentRow = startPos[0];
            int currentCol = startPos[1];

            // Simulate the moves from the i-th instruction to the end
            for (int j = i; j < m; j++) {
                char move = s.charAt(j);

                if (move == 'L') currentCol--;
                else if (move == 'R') currentCol++;
                else if (move == 'U') currentRow--;
                else if (move == 'D') currentRow++;

                // Check if the robot is still within the n x n grid
                if (currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n) {
                    count++;
                } else {
                    // Robot moved off the grid, stop this simulation
                    break;
                }
            }
            result[i] = count;
        }

        return result;
    }
}