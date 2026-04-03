class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        // We pass '1' as the initial "last" digit so the first char can be 0 or 1
        backtrack(n, 1, "", result);
        return result;
    }

    private void backtrack(int n, int lastDigit, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Option 1: Always allowed to add '1'
        backtrack(n, 1, current + "1", result);

        // Option 2: Only allowed to add '0' if the last digit was '1'
        if (lastDigit == 1) {
            backtrack(n, 0, current + "0", result);
        }
    }
}