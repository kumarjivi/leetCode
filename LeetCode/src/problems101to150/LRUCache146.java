package problems101to150;

import java.util.HashMap;
import java.util.Map;

/***
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author jivi
 *
 */
public class LRUCache146 {

	public static void main(String[] args) {
		LRUCache146 obj = new LRUCache146(2);
		System.out.println(obj.get(2));
		obj.put(2, 6);
		System.out.println(obj.get(1));
		obj.put(1, 5);
		obj.put(1, 2);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
	}

	static class Node {
		int key;
		int val;
		Node prev;
		Node next;

		Node(int k, int v) {
			this.key = k;
			this.val = v;
		}

		Node() {
		}
	}

	static int maxSize = 0, size = 0;
	static Map<Integer, Node> map = null;
	static Node head = null;
	static Node tail = null;

	LRUCache146(int capacity) {
		this.maxSize = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public static int get(int key) {
		if (map.containsKey(key)) {
			Node node = removeNode(map.get(key));
			addToTail(node);
			return node.val;
		}
		return -1;
	}

	public static void put(int key, int value) {
		if (map.containsKey(key)) {
			Node oldNode = map.get(key);
			removeNode(oldNode);
		} else if (size == maxSize) {
			Node node = removeNode(head.next);
			map.remove(node.key);
		}

		Node nodeToAdd = new Node(key, value);
		addToTail(nodeToAdd);
		map.put(key, nodeToAdd);
	}

	private static void addToTail(Node node) {
		if (tail.prev == head) {
			head.next = node;
			node.prev = head;
		} else {
			Node prev = tail.prev;
			prev.next = node;
			node.prev = prev;
		}
		node.next = tail;
		tail.prev = node;
		size++;
	}

	private static Node removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;
		size--;
		return node;
	}

}
