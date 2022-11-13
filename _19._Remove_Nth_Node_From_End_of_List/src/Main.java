public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode test;
		test = new ListNode(1, new ListNode(2, new ListNode(3)));
		printList(sol.removeNthFromEnd(test, 1));
		test = new ListNode(1, new ListNode(2, new ListNode(3)));
		printList(sol.removeNthFromEnd(test, 2));
		test = new ListNode(1, new ListNode(2, new ListNode(3)));
		printList(sol.removeNthFromEnd(test, 3));
	}

	private static void printList(ListNode list) {
		while (list != null) {
			System.out.print(list.val + " -> ");
			list = list.next;
		}
		System.out.println();
	}

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	static class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode iterator = head;
			ListNode cur = head;
			ListNode prev = head;
			boolean firstIteration = true;

			for (int i = 1; i < n; i++)
				iterator = iterator.next;

			while (iterator.next != null) {
				if (!firstIteration)
					prev = prev.next;
				else
					firstIteration = false;
				iterator = iterator.next;
				cur = cur.next;
			}
//			if head == iterator then list contains only one element
			if (head == iterator)
				return null;
//			if current == head then we need to move the first element
			else if (cur == head)
				return head.next;
//			if cur == iterator then we need to delete the last element
			else if (cur == iterator) {
				prev.next = null;
			} else {
				prev.next = cur.next;
			}
			return head;
		}
	}
}