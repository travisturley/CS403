/*
	LeetCode #322 (Coin Change)
*/
class Solution
{
    public int coinChange(int[] coins, int amount)
    {
        int max = amount + 1; // the maximum number of coins needed will never exceed the amount + 1
        int[] dp = new int[amount + 1]; // dp[i] stores minimum number of coins needed to make up amount i
        Arrays.fill(dp, max); // initialize all values to max (haven't computed any results yet)
        dp[0] = 0; // 0 coins are needed to make amount 0

        for (int i = 1; i <= amount; i++) // compute dp[i] for all amounts from 1 to amount
        {
            for (int coin : coins) // try every coin denomination to see which gives the smallest result
            {
                if (coin <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // if can use coin, check the result of (i - coin) and add one more coin to combination
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount]; // if dp[amount] is still max, couldn't form that amount
    }
}