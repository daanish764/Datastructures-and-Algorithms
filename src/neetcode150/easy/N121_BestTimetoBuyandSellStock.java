package neetcode150.easy;

public class N121_BestTimetoBuyandSellStock {



    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }



    public static int maxProfit(int[] prices) {

        if(prices.length<2) return 0;

        int maxProfit = 0;

        int buy = 0;
        int sell = buy + 1;

        while(sell < prices.length) {
            if(prices[sell] < prices[buy]) {
                buy = sell;
            }
            else {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }

            sell++;
        }

        return maxProfit;
    }

}
