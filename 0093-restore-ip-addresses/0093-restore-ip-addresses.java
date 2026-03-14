import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int index, int parts, String current, List<String> res) {
        if (parts == 4 && index == s.length()) {
            res.add(current.substring(0, current.length() - 1));
            return;
        }

        if (parts >= 4 || index >= s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if ((part.length() > 1 && part.startsWith("0")) || Integer.parseInt(part) > 255)
                continue;

            backtrack(s, index + len, parts + 1, current + part + ".", res);
        }
    }
}
