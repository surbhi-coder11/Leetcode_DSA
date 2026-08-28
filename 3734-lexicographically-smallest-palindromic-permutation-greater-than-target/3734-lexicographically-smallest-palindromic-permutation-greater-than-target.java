class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check whether a palindrome can be formed.
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Number of characters available in the left half.
        int[] leftCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            leftCnt[i] = cnt[i] / 2;
        }

        int m = n / 2;

        // Try every possible position where the answer
        // becomes greater than target.
        for (int pos = m; pos >= 0; pos--) {

            int[] rem = leftCnt.clone();

            // Build prefix equal to target.
            boolean ok = true;

            for (int i = 0; i < pos; i++) {
                int c = target.charAt(i) - 'a';

                if (rem[c] == 0) {
                    ok = false;
                    break;
                }

                rem[c]--;
            }

            if (!ok) {
                continue;
            }

            // If pos == m, left half is exactly target's left half.
            if (pos == m) {
                String left = target.substring(0, m);

                StringBuilder candidate = new StringBuilder(left);

                if (n % 2 == 1) {
                    candidate.append(mid);
                }

                candidate.append(new StringBuilder(left).reverse());

                if (candidate.toString().compareTo(target) > 0) {
                    return candidate.toString();
                }

                continue;
            }

            // Try the smallest character > target[pos].
            int cur = target.charAt(pos) - 'a';

            for (int c = cur + 1; c < 26; c++) {

                if (rem[c] == 0) {
                    continue;
                }

                StringBuilder left = new StringBuilder();

                // Same prefix.
                left.append(target, 0, pos);

                // Make this position larger.
                left.append((char) ('a' + c));

                rem[c]--;

                // Smallest possible suffix.
                for (int x = 0; x < 26; x++) {
                    while (rem[x] > 0) {
                        left.append((char) ('a' + x));
                        rem[x]--;
                    }
                }

                StringBuilder ans = new StringBuilder(left);

                if (n % 2 == 1) {
                    ans.append(mid);
                }

                ans.append(new StringBuilder(left).reverse());

                return ans.toString();
            }
        }

        return "";
    }
}