/*
	Longest Substring Without Repeating Characters (LeetCode #3)
*/
class Solution
{
    public int lengthOfLongestSubstring(String s)
	{
        HashSet<Character> seen = new HashSet<>(); // set for keeping track of chars currently in the window
        
        int left = 0; // left pointer of window
        int maxLength = 0; // length of longest substring found so far
        
        for (int right = 0; right < s.length(); right++) // expand right pointer one char at a time
		{
            char currentChar = s.charAt(right);
            
            // if duplicate char found, move left pointer until duplicate char is removed from set
            while (seen.contains(currentChar))
			{
                seen.remove(s.charAt(left));
                left++; // shrink window from left side
            }
            
            seen.add(currentChar); // add current char to set (no duplicates in window now)
            
            maxLength = Math.max(maxLength, right - left + 1); // update maxLength if current window is larger
        }
        
        return maxLength;
    }
}