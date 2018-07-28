package problems1to50;

public class MergeKSortedLists23 {
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(0);
		ListNode ans = mergeTwoLists(one, two);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}

	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode ans = lists[0];
        if(lists.length == 1) return ans;
        for(int i=0; i<lists.length-1; i++) {
            ans = mergeTwoLists(ans, lists[i+1]);
        }
        return ans;
    }
	
	public static ListNode mergeTwoLists(ListNode one, ListNode two) {
        if(one == null) return two;
        if(two == null) return one;
        ListNode result = one;
        while(two != null) {
            int val1 = one.val;
            int val2 = two.val;
            ListNode temp = two;
            
            if(val1 <= val2) {
                if(one.next == null || one.next.val > val2) {
                    //insert two after one.
                    two = two.next;
                    temp.next = one.next;
                    one.next = temp;
                }
                one = one.next;
            } else {
                //insert two before one
                two = two.next;
                temp.next = one;
                one = temp;
                result = one;
            }
        }
        return result;
    }

}
