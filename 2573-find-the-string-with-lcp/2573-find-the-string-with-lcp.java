class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] res = new char[n];
        char cur = 'a';

        // Greedy Construction
        for (int i = 0; i < n; i++) {
            if (res[i] != 0) continue;
            if (cur > 'z') return ""; // More than 26 characters needed
            
            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) {
                    res[j] = cur;
                }
            }
            cur++;
        }

        // Validation
        int[][] check = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    check[i][j] = check[i + 1][j + 1] + 1;
                } else {
                    check[i][j] = 0;
                }
                
                // Compare with original matrix
                if (check[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(res);
    }
}