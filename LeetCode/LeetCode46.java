/*
	Permutations (LeetCode #46)
*/

class Solution
{
    public List<List<Integer>> permute(int[] nums)
	{
        List<List<Integer>> result = new ArrayList<>(); // stores generated permutations
        boolean[] used = new boolean[nums.length]; // keeps track of which numbers are currently in the path (so don't reuse same number twice)
        backtrack(nums, used, new ArrayList<>(), result); // backtrack with empty path
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result)
	{
        if (path.size() == nums.length) // if current path contains all numbers, that's a full permutation, so add it to result
		{
            result.add(new ArrayList<>(path)); // add copy of path to result
            return;
        }

        for (int i = 0; i < nums.length; i++) // else, try adding each number that's not been used yet
		{
            if (used[i]) continue; // if nums[i] is already used in the current path, then skip it
            used[i] = true; // mark nums[i] as used
            path.add(nums[i]); // add nums[i] to current permutation path

            backtrack(nums, used, path, result); // build rest of the permutation

            path.remove(path.size() - 1); // undo last choice, so can try another number
            used[i] = false; // make nums[i] false (so can be re-used again in another permutation)
        }
    }
}