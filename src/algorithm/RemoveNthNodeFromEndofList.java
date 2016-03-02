package algorithm;

import common.ListNode;


/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 */

public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		
		int i = 1;
		ListNode l1 = head;
		ListNode l2 = head;
		while (l2.next != null) {
			if (i > n) {
				l1 = l1.next;
			}
			l2 = l2.next;
			i++;
		}
		if (i == n)
			head = head.next;
		else
			l1.next = l1.next.next;
		return head;

	}

	public static void main(String[] args) {

		ListNode h = new ListNode(1);

		
		ListNode c = h;
		for (int i = 2; i <=5; i ++)
		{			
			ListNode n = new ListNode(i);
			c.next = n;
			c = c.next;			
		}
		
		ListNode x = removeNthFromEnd(h, 5);
		
    	while (x != null)
    	{
			System.out.println(x.val);
			x = x.next;
    	}
    	

	}

}
