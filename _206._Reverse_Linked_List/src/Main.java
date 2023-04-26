public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		print(solution.reverseList(head));
		head = new ListNode();
		print(solution.reverseList(head));
		head = new ListNode(1);
		print(solution.reverseList(head));
		head = null;
		print(solution.reverseList(head));
	}

	private static void print(ListNode head) {
		if (head == null)
			System.out.println("NULL");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

	static public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	static class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return null;
			ListNode prev = head;
			ListNode tmp;
			ListNode cur = head.next;

			head.next = null;

			while (cur != null) {
				tmp = cur;
				cur = cur.next;
				tmp.next = prev;
				prev = tmp;
			}

			return prev;
		}
	}
}