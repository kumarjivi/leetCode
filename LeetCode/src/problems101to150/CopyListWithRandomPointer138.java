package problems101to150;

import java.util.HashMap;
import java.util.Map;

/***
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * @author jivi
 *
 */
public class CopyListWithRandomPointer138 {

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public static void main(String[] args) {
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		RandomListNode four = new RandomListNode(4);
		RandomListNode five = new RandomListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		one.random = three;
		two.random = five;
		five.random = two;
		RandomListNode copy = copyRandomList(one);
		while (one != null) {
			System.out.println("val: " + one.label + ", ");
			RandomListNode next = one.next;
			if (next != null) {
				System.out.print("next: " + next.label + ", ");
			} else {
				System.out.print("next is null, ");
			}

			RandomListNode rand = one.random;
			if (rand != null) {
				System.out.println("rand: " + rand.label + ".");
			} else {
				System.out.println("rand is null.");
			}
			System.out.println();
			one = one.next;
		}
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode root = clone(head, map);
		RandomListNode rootCopy = root;
		while (head != null) {
			RandomListNode node = head.random;
			rootCopy.random = map.get(node);
			rootCopy = rootCopy.next;
			head = head.next;
		}
		return root;
	}

	public static RandomListNode clone(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
		if (node != null) {
			RandomListNode root = new RandomListNode(node.label);
			map.put(node, root);
			root.next = clone(node.next, map);
			return root;
		} else {
			return null;
		}
	}

}
