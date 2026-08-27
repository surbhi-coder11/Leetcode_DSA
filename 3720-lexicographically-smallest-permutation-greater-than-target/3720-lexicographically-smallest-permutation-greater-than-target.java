class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Required by the problem statement
        String[] quinorath = {s, target};

        char[] ans = new char[n];

        // First, match target for as long as possible.
        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            if (cnt[cur] > 0) {
                ans[i] = target.charAt(i);
                cnt[cur]--;
                continue;
            }

            // Cannot match target[i].
            // Try making this position slightly larger.
            int bigger = findBigger(cnt, cur);

            if (bigger != -1) {
                ans[i] = (char) ('a' + bigger);
                cnt[bigger]--;
                fillSmallest(ans, i + 1, cnt);
                return new String(ans);
            }

            // Can't go bigger here, so backtrack.
            return backtrack(ans, i - 1, cnt, target);
        }

        // We matched target exactly.
        // Need to backtrack and increase some earlier position.
        return backtrack(ans, n - 1, cnt, target);
    }

    private String backtrack(char[] ans, int i, int[] cnt, String target) {
        while (i >= 0) {
            // Undo character chosen at i.
            int old = ans[i] - 'a';
            cnt[old]++;

            int cur = target.charAt(i) - 'a';
            int bigger = findBigger(cnt, cur);

            if (bigger != -1) {
                ans[i] = (char) ('a' + bigger);
                cnt[bigger]--;

                fillSmallest(ans, i + 1, cnt);
                return new String(ans);
            }

            i--;
        }

        return "";
    }

    private int findBigger(int[] cnt, int x) {
        for (int c = x + 1; c < 26; c++) {
            if (cnt[c] > 0) {
                return c;
            }
        }
        return -1;
    }

    private void fillSmallest(char[] ans, int start, int[] cnt) {
        int pos = start;

        for (int c = 0; c < 26; c++) {
            while (cnt[c] > 0) {
                ans[pos++] = (char) ('a' + c);
                cnt[c]--;
            }
        }
    }
}