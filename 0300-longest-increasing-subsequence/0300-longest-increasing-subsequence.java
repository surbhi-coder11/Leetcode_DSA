import java.util.*;
class Solution {
    public int LCS(int[] nums, int[] nums2){
        int n = nums.length;
        int m = nums2.length;

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        
        Set<Integer> hp = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hp.add(nums[i]);
        }
        int[] nums2 = new int[hp.size()];
        int i=0;
        for(int num : hp){
           nums2[i] = num;
           i++;
        }
        Arrays.sort(nums2);
        return LCS(nums,nums2);
    }
}