class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);
    }
}