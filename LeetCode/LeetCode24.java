 /*
	Swap Nodes in Pairs (LeetCode #24)
 */
class Solution
{
    public ListNode swapPairs(ListNode head)
    {
        // Dummy node to make handling head swaps easier
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prevNode points to node before current pair
        ListNode prevNode = dummy;

        // Loop while there are (at least) two nodes ahead
        while (head != null && head.next != null)
        {
            // Identify two nodes to swap
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swap
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move pointers forward for next swap
            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next; // Return new head (dummy.next points to it)
    }
}