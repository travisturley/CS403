/*
    Happy Number (LeetCode #202)
*/
public class Solution
{
    public boolean isHappy(int n) // check if number is happy
    {
        int slow = n; // start at original number
        int fast = getNext(n); // start at next number that moves 2x as fast

   f     while (fast != 1 && slow != fast) // Loop until either fast reaches 1 (happy) or slow & fast meet (not happy)
        {
            slow = getNext(slow); // slow moves forward 1 step
            fast = getNext(getNext(fast)); // fast moves forward 2 steps
        }

        return fast == 1; // if fast reached 1, number is happy. Otherwise, slow is equal to fast, so it's not happy
    }

    private int getNext(int n) // compute next number in sequence & replace n with sum
    {
        int totalSum = 0;

        while (n > 0) // Loop to extract each digit, then square & add to totalSum
        {
            int digit = n % 10; // get last digit
            totalSum += digit * digit; // square & add sum
            n /= 10;  // drop last digit
        }

        return totalSum;
    }
}