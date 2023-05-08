import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1); // cache is {1=1}
		cache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(cache.get(1) + " must be 1");    // return 1
		cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(cache.get(2) + " must be -1"); // returns -1 (not found)
		cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(cache.get(1) + " must be -1"); // returns -1 (not found)
		System.out.println(cache.get(3) + " must be 3"); // return 3
		System.out.println(cache.get(4) + " must be 4"); // return 4
		System.out.println("--------------------------------");
		cache = new LRUCache(2);
		cache.put(2, 1); // cache is {1=1}
		cache.put(1, 1); // cache is {1=1, 2=2}
		cache.put(2, 3); // cache is {1=1, 2=2}
		cache.put(4, 1); // cache is {1=1, 2=2}
		System.out.println(cache.get(1) + " must be -1"); // returns -1 (not found)
		System.out.println(cache.get(2) + " must be 3");    // return 3
		System.out.println("--------------------------------");
		cache = new LRUCache(3);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.put(4,4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(5,5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}

	static class LRUCache {
		int capacity;
		int curCapacity;
		Map<Integer, ListNode> map;
		ListNode head;
		ListNode tail;

		static class ListNode {
			ListNode prev;
			ListNode next;
			int key;
			int value;


			public ListNode(ListNode next, int key, int value) {
				this.next = next;
				this.value = value;
				this.key = key;
			}
		}

		public LRUCache(int capacity) {
			this.capacity = capacity;
			map = new HashMap<>();
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				ListNode node = map.get(key);
				moveToHead(node);
				return node.value;
			} else {
				return -1;
			}
		}

		public void put(int key, int value) {
//			update, if exists already
			if (map.containsKey(key)) {
				ListNode node = map.get(key);
				node.value = value;
				moveToHead(node);
			} else if (curCapacity < capacity) {
				ListNode node = new ListNode(head, key, value);
				if (head != null)
					head.prev = node;
				else
					tail = node;
				head = node;
				map.put(key, node);
				curCapacity++;
			} else {
				ListNode node = new ListNode(head, key, value);
				head.prev = node;
				head = node;
				map.put(key, node);

				removeFromTail();
			}
		}

		private void moveToHead(ListNode node) {
			if (node == head)
				return;

			node.prev.next = node.next;
			if (node == tail)
				tail = node.prev;

			if (node.next != null)
				node.next.prev = node.prev;

			head.prev = node;
			node.next = head;
			head = node;
		}

		private void removeFromTail() {
			ListNode node = tail;
			tail = tail.prev;
			tail.next = null;
			map.remove(node.key);
		}
	}
}