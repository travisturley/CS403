/*
	Daily Temperatures (LeetCode #739)
*/
class Solution
{
    public int[] dailyTemperatures(int[] temperatures)
	{
        int n = temperatures.length;
        int[] answer = new int[n]; // create array of the same length as temperatures
        Stack<Integer> stack = new Stack<>(); // Index storage of days whose warmer day hasn't yet been found

        for (int i = 0; i < n; i++) // Loop through each day
		{
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) // while stack isn't empty & current temperature is warmer than the top of the stack
			{
                int prevIndex = stack.pop(); // pop index prev
				// wait time is i - prev
                answer[prevIndex] = i - prevIndex; // set answer[prev] as i - prev
            }
			
            stack.push(i); // push current day index i onto stack
			// any index left in stack never gets a warmer day, so their value stays 0
        }

        return answer;
    }
}