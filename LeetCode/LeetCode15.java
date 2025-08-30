/*
    3Sum (LeetCode #15)
*/
class Solution
{
    public List<List<Integer>> threeSum(int[] ints)
    {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(ints); // Sort the array (so you can skip duplicates)

        for (int i = 0; i < ints.length - 2; i++) // loop through array (using index i)
        {
            if (i > 0 && ints[i] == ints[i - 1])
            {
                continue; // check for match (skips ints[i] duplicates)
            }

            // use two-pointer strat
            int left = i + 1;
            int right = ints.length - 1;

            while (left < right)
            {
                int sum = ints[i] + ints[left] + ints[right]; // figure out what the sum is

                if (sum == 0)
                {
                    answer.add(Arrays.asList(ints[i], ints[left], ints[right])); // store

                    while (left < right && ints[left] == ints[left + 1])
                    {
                        left++; // skip duplicate ints[left]
                    }
                    while (left < right && ints[right] == ints[right - 1])
                    {
                        right--; // skip duplicate ints[right]
                    }
                    // move pointers in
                    left++;
                    right--;
                }
                else if (sum < 0)
                {
                    left++; // need larger int
                }
                else
                {
                    right--; // need smaller int
                }
            }
        }

        return answer;
    }
}