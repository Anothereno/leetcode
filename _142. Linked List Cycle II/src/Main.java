public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode list1Node, list2Node, list3Node, list4Node;
		list1Node = new ListNode(1);
		list2Node = new ListNode(2);
		list3Node = new ListNode(3);
		list4Node = new ListNode(4);
		list1Node.next = list2Node;
		list2Node.next = list3Node;
		list3Node.next = list4Node;
		printList(solution.detectCycle(list1Node));

		list1Node = new ListNode(1);
		list2Node = new ListNode(2);
		list3Node = new ListNode(3);
		list4Node = new ListNode(4);
		list1Node.next = list2Node;
		list2Node.next = list3Node;
		list3Node.next = list4Node;
		list4Node.next = list2Node;
		printList(solution.detectCycle(list1Node));

		list1Node = new ListNode(1);
		list2Node = new ListNode(2);
		list3Node = new ListNode(3);
		list4Node = new ListNode(4);
		list1Node.next = list2Node;
		list2Node.next = list3Node;
		list3Node.next = list4Node;
		list4Node.next = list3Node;
		printList(solution.detectCycle(list1Node));

		list1Node = new ListNode(1);
		printList(solution.detectCycle(list1Node));

		
	}

	private static void printList(ListNode list) {
		if (list == null) System.out.println("null");
		else System.out.println(list.val);
	}

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}

	static public class Solution {
		public ListNode detectCycle(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) break;
			}

			if (fast == null || fast.next == null)
				return null;
			while (head != slow) {
				head = head.next;
				slow = slow.next;
			}
			return head;
		}
	}


}