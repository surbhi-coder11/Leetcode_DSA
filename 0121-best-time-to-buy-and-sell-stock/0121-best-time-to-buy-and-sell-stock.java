class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int profit =0;
        for(int i=1;i<prices.length;i++){
            minprice= Math.min(prices[i],minprice);
           profit = Math.max(profit,prices[i]-minprice);
        }
        return profit;
    }
}