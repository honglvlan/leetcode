package algorithm;

import common.SingleLinkListNode;
import common.SingleLinkList;


public class ReverseSingleLinkList {

	//方法：链表的反转
	public static SingleLinkListNode reverseList(SingleLinkListNode head) {
	 
	//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
	 if (head == null || head.next == null) {
	 return head;
	}
	 
	SingleLinkListNode next = null; //当前结点的下一个结点
	SingleLinkListNode reversedHead = null; //反转后的头结点
	 
	while (head != null) {
	 next = head.next; //暂时保存住当前结点的下一个结点，因为下一次要用
	 head.next = reversedHead;
	 reversedHead = head;
	 head = next;
	}
	 
	return reversedHead;
	}
	
	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		//向LinkList中添加数据
		 for (int i = 0; i < 10; i++) {
		 list.add(i);
		 }
		 
		 list.print(list.head);// 从head节点开始遍历输出
		 

		 SingleLinkListNode reversed = reverseList(list.head);
		 
		 list.print(reversed);
		 
		 
		 
		}
	
}
