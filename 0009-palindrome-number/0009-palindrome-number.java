class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)){
            return false;
        }

        int leftover = x;
        int rev = 0;
        while(leftover>rev){
            int rem = leftover%10;
            rev = rev*10+rem;
            leftover/=10;
        }
        if(leftover==rev || leftover == rev/10){
           return true;
        }

        return false;
    }
}