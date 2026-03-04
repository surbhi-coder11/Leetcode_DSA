import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        String[] map = {
            "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };

        backtrack(result, new StringBuilder(), digits, map, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current,
                           String digits, String[] map, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(result, current, digits, map, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
