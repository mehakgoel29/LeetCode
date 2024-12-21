public class BuySellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int bestBuy=prices[0]; //this cannot be a selling day
            for (int i = 0; i < prices.length; i++) {
                if(prices[i]>bestBuy){
                    int profitForDay=prices[i]-bestBuy;
                    maxProfit=Math.max(maxProfit,profitForDay);
                }
                bestBuy=Math.min(bestBuy,prices[i]);
            }
            return maxProfit;
        } 
        }
    
}
