/*
	Find Minimum in Rotated Sorted Array (LeetCode # 153)
*/

class Solution
{
    public int findMin(int[] nums)
    {
        int left = 0, right = nums.length - 1;

        while (left < right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) // minimum is to right
            {
                left = mid + 1;
            } 
            else // minimum is at midpoint or to left
            {
                right = mid;
            }
        }

        return nums[left]; // left is equal to right is the index of minimum
    }
}