import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        
        char[] res = new char[len];
        Arrays.fill(res, '?');
        boolean[] fixed = new boolean[len];

        // Step 1: Handle all 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != '?' && res[i + j] != str2.charAt(j)) {
                        return ""; // Contradiction between 'T' constraints
                    }
                    res[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        // Step 2: Fill remaining with 'a' (the smallest possible char)
        for (int i = 0; i < len; i++) {
            if (res[i] == '?') res[i] = 'a';
        }

        // Step 3: Satisfy 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (isMatch(res, i, str2)) {
                    // Try to change the rightmost unfixed character to satisfy 'F'
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            // If it's 'a', change to 'b'. If it's already something else,
                            // changing it to 'a' might violate something, but we started at 'a'.
                            // Changing to 'b' is the minimal increment to break the match.
                            res[i + j] = (res[i + j] == 'a') ? 'b' : 'a'; 
                            
                            // Note: Since we only change unfixed 'a' to 'b' (or vice versa),
                            // we don't need to re-check previous 'F's as long as we proceed 
                            // carefully. But in this problem, simply changing the rightmost 
                            // unfixed char to 'b' (or 'a' if it was already 'b' for some reason) 
                            // is sufficient.
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) return ""; // All chars in this 'F' window are fixed by 'T's
                }
            }
        }

        // Step 4: Final validation (ensure our 'F' fixes didn't create new 'T' matches)
        // This is necessary because changing a char for an 'F' might trigger a match for 
        // a different index that was supposed to be 'F'.
        for (int i = 0; i < n; i++) {
            boolean actualMatch = isMatch(res, i, str2);
            if (str1.charAt(i) == 'T' && !actualMatch) return "";
            if (str1.charAt(i) == 'F' && actualMatch) return "";
        }

        return new String(res);
    }

    private boolean isMatch(char[] res, int start, String pattern) {
        for (int j = 0; j < pattern.length(); j++) {
            if (res[start + j] != pattern.charAt(j)) return false;
        }
        return true;
    }
}