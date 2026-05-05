class Solution {
    public boolean rotateString(String s, String goal) {
        boolean s1 = s.length() == goal.length();
        boolean s2 = (s + s).contains(goal);
        return  s1&& s2;
    }
}