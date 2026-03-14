class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backtrack(n, "", list);
        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(int n, String current, List<String> list) {
        if (current.length() == n) {
            list.add(current);
            return;
        }

        char[] chars = {'a', 'b', 'c'};
        for (char c : chars) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
                backtrack(n, current + c, list);
            }
        }
    }
}
