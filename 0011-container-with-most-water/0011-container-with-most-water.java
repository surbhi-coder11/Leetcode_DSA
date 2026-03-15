class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int maxvol = 0;
        while(lp<=rp){
            int width = rp - lp ;
            int len = Math.min(height[lp], height[rp]);
            int currvol = width * len;
            maxvol = Math.max(currvol , maxvol);
            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxvol;
    }
}