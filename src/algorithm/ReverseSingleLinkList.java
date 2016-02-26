package algorithm;

import common.SingleLinkListNode;
import common.SingleLinkList;


public class ReverseSingleLinkList {

	//����������ķ�ת
	public static SingleLinkListNode reverseList(SingleLinkListNode head) {
	 
	//�������Ϊ�ջ���ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���ԭ�����ͷ���
	 if (head == null || head.next == null) {
	 return head;
	}
	 
	SingleLinkListNode next = null; //��ǰ������һ�����
	SingleLinkListNode reversedHead = null; //��ת���ͷ���
	 
	while (head != null) {
	 next = head.next; //��ʱ����ס��ǰ������һ����㣬��Ϊ��һ��Ҫ��
	 head.next = reversedHead;
	 reversedHead = head;
	 head = next;
	}
	 
	return reversedHead;
	}
	
	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		//��LinkList���������
		 for (int i = 0; i < 10; i++) {
		 list.add(i);
		 }
		 
		 list.print(list.head);// ��head�ڵ㿪ʼ�������
		 

		 SingleLinkListNode reversed = reverseList(list.head);
		 
		 list.print(reversed);
		 
		 
		 
		}
	
}
