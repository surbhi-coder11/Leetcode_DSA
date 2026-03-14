class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buyp = prices[0];
        for(int i=0;i<prices.length;i++){
            if(buyp<prices[i]){
                int profit = prices[i] - buyp;
                maxprofit = Math.max(maxprofit , profit);
            }else {
               buyp = prices[i];
            }
        }

        return maxprofit;
    }
}