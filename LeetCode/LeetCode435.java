/*
	Non-Overlapping Intervals (LeetCode #435)
*/
public class Solution
{
    public int eraseOverlapIntervals(int[][] intervals)
    {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // sort intervals by their end time (ascending)

        int count = 0; // number of non-overlapping intervals kept
        int end = Integer.MIN_VALUE; // end point of the last kept interval

        for (int[] interval : intervals) // iterate over each interval [start, finish]
        {
            if (interval[0] >= end) // if current interval does not overlap with last kept
            { 
                count++; // keep this interval
                end = interval[1]; // update end boundary
            }
            // Otherwise, skip this interval (which means remove it)
        }

        return intervals.length - count; // minimum removals is equal to total intervals minus kept intervals
    }
}