/*
	Binary Tree Paths (LeetCode #257)
*/
class Solution // using recursion
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        ArrayList<String> answer = new ArrayList<String>();

        if (root == null)
        {
            return answer; // return if null
        }

        search(root, "", answer); // Start search from the root with an empty path "".

        return answer;
    }

    private void search(TreeNode node, String path, List<String> answer)
    {
        if (node == null)
        {
            return; // return if null
        }

        if (path.isEmpty()) // At each node, append value to path
        {
            path += node.val;
        }
        else
        {
            path += "->" + node.val;
        }

        if (node.left == null && node.right == null) // if node has no children, save the path to answer.
        {
            answer.add(path);

            return;
        }

        // else, recursion for the left/right sub-trees.
        search(node.left, path, answer);
        
        search(node.right, path, answer);
    }
}