class Solution {
    public boolean canBeEqual(String s1, String s2) {
        boolean evencheck = (s1.charAt(0)==s2.charAt(0) && s1.charAt(2)==s2.charAt(2))|| (s1.charAt(0)==s2.charAt(2) && s1.charAt(2)==s2.charAt(0));
        boolean oddcheck = (s1.charAt(1)==s2.charAt(1) && s1.charAt(3)==s2.charAt(3)) || (s1.charAt(1)==s2.charAt(3) && s1.charAt(3)==s2.charAt(1));


        return evencheck && oddcheck;
    }
}