// Keerthilal wants to try his luck in Diamonds business. 
// He decides to buy and sell diamonds. 

// He is given the prices of one diamond for N days by his friend.
// Initially, it is assumed that he has no diamonds.

// You need to help Keerthilal in making the maximum profit that is possible. 
// He can sell a diamond only after he buys a diamond. 

// Note: 
//     - He is allowed to do any number of transactions
//       but, he can buy and sell only one diamond per transaction.
    
//     - He must complete one transaction before the next transaction.
    
//     - After each transaction completed, there is a break day.
//     i.e After he sells his diamond, he cannot buy diamond on next day.

		
// Input Format:
// -------------
// Space separated integers, price of the diamond for N days.

// Output Format:
// --------------
// Print an integer, maximum profit.


// Sample Input-1:
// ---------------
// 7 1 5 3 6 4

// Sample Output-1:
// ----------------
// 5

// Explanation: 
// ------------
// Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.


// Sample Input-2:
// ---------------
// 1 2 3 1 3

// Sample Output-2:
// ----------------
// 3

// Explanation: 
// ------------
// Buy on day 1 (price = 1) and sell on day 2 (price = 2), profit = 2-1 = 1.
// day 3 is a break.
// Buy on day 4 (price = 1) and sell on day 5 (price = 3), profit = 3-1 = 2.
// Total Maximum Profit = 1+2 = 3



import java.util.Scanner;
public class Diamond {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];  

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if (i > 1) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            }
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] prices = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        int result = maxProfit(prices);
        System.out.println(result);
    }
}
