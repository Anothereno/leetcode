public class Main {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		print(swapNodes(head, 4));
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}

	public static ListNode swapNodes(ListNode head, int k) {
		ListNode iterator = head;
		ListNode leftBoard = head;
		ListNode rightBoard = head;

		while (iterator.next != null) {
			if (k > 2) leftBoard = leftBoard.next;
			if (k < 1) rightBoard = rightBoard.next;
			k--;
			iterator = iterator.next;
		}
		System.out.println(leftBoard.val);
		System.out.println(rightBoard.val);
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
