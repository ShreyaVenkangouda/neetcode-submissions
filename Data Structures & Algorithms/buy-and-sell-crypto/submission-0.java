class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int minPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = Math.min(minPrice,prices[i]);
            }
            profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
