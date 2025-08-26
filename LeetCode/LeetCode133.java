/*
	Clone Graph (LeetCode #133)
*/
class Solution // using recursion
{
    private HashMap<Node, Node> visitedNodes = new HashMap<Node, Node>(); // hashmap stops infinite loop

    public Node cloneGraph(Node node)
    {
        if (node == null)
        {
            return null; // return if null
        }

        if (visitedNodes.containsKey(node))
        {
            return visitedNodes.get(node); // return clone (if already cloned)
        }

        Node clone = new Node(node.val); // Clone node without neighbors
        
        visitedNodes.put(node, clone);

        for (Node neighbor : node.neighbors) // Then, recursively clone the neighbors
        {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone; // finally, return clone node
    }
}