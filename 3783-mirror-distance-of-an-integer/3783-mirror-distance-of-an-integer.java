class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int num =n;
        while(n>0){
            int d = n%10;
            rev= rev*10 +d;
            n = n/10;
        }

        return Math.abs(num-rev);
    }
}