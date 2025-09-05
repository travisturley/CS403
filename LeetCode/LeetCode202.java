public class Solution
{
    public boolean isHappy(int n) // check if a number is happy number
    {
        int slow = n; // start at original number
        int fast = getNext(n); // start at next number that moves twice as fast

   f     while (fast != 1 && slow != fast) // Loop until either fast reaches 1 (happy) or slow & fast meet (not happy)
        {
            slow = getNext(slow); // slow moves forward one step
            fast = getNext(getNext(fast)); // fast moves forward two steps
        }

        return fast == 1; // If fast reached 1, the number is happy; else, slow == fast, so it's not happy
    }

    private int getNext(int n) // compute the "next" number in the sequence & replace n with the sum of quares of digits
    {
        int totalSum = 0;

        while (n > 0) // Extract each digit, square, then add to totalSum
        {
            int digit = n % 10; // get last digit
            totalSum += digit * digit; // square & add to sum
            n /= 10;  // drop last digit
        }

        return totalSum;
    }
}