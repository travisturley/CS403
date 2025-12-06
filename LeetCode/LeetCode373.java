/*
	Find K Pairs with Smallest Sums (LeetCode # 373)
*/

class Solution
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0) // if either array is empty, no pairs can be formed
        {
            return result;
        }

        // minHeap entry format is [sum, i, j], where sum is equal to nums1[i] + nums2[j], i is the index in nums1, & j is the index in nums2
        PriorityQueue<int[]> minHeap = new PriorityQueue<>
        (
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // initialize with the pairs nums1[i], nums2[0] for i equals 0 .. min(nums1.length-1, k-1)
        for (int i = 0; i < nums1.length && i < k; i++)
        {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) // extract the k smallest pairs
        {
            int[] top = minHeap.poll();
            int i = top[1], j = top[2];

            result.add(Arrays.asList(nums1[i], nums2[j])); // Add the actual pair

            // push next pair involving nums1[i]: (nums1[i], nums2[j+1]), which moves horizontally across nums2
            if (j + 1 < nums2.length)
            {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return result;
    }
}