package algorithm;
import common.SingleLinkList;
import common.SingleLinkListNode;

//Source : https://oj.leetcode.com/problems/add-two-numbers/
/********************************************************************************** 
* 
* You are given two linked lists representing two non-negative numbers. 
* The digits are stored in reverse order and each of their nodes contain a single digit. 
* Add the two numbers and return it as a linked list.
* 
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
*               
**********************************************************************************/



public class AddTwoNumbers {

    
	
	public static SingleLinkListNode addTwoNumbers(SingleLinkListNode head1, SingleLinkListNode head2)
    {
    	int carry = 0;
    	int sum = 0;
    	SingleLinkListNode current = null;
    	SingleLinkListNode next = null;
    	SingleLinkListNode head = null;
    	while (head1 != null || head2 != null)
    	{
    		int data1 = 0;
    		int data2 = 0;
    		if (head1 != null)
    		{
    			data1 = head1.data;
    			head1 = head1.next;
    		}
    		
    		if (head2 != null)
    		{
    			data2 = head2.data;
    			head2 = head2.next;
    		}
    		
    		
    		sum = carry + data1 + data2;
    		carry = sum / 10;
    		
    		next = new SingleLinkListNode(sum % 10);
    		if (head == null)
    		{
    			head = next;
    		}
    		
    		
    		if (current == null)
    		{
    			current = next;
    		}
    		else
    		{
    			current.next = next;
    			current = next;
    		}
    	}
    	
    	if (carry > 0 )
    	{
    		SingleLinkListNode newNode = new SingleLinkListNode(carry);
    		current.next = newNode;
    	}
    	
    	return head;
    }
	
	public static void main(String[] args)
	{
		SingleLinkList list1 = new SingleLinkList();
		SingleLinkList list2 = new SingleLinkList();
		int[] data1 = {2, 4, 9};
		int[] data2 = {5, 6, 4};
		list1.add(data1);
		list2.add(data2);
		//list1.print(list1.head);
		//list2.print(list2.head);
		
		SingleLinkListNode resultHead = addTwoNumbers(list1.head, list2.head);
		list2.print(resultHead);
		
	}
}
