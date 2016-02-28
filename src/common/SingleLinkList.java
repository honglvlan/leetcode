package common;

/**
 * 
 * 
 * http://www.jb51.net/article/71885.htm
 * 
 * 
 * @author angyong
 * 
 */
public class SingleLinkList {
	public SingleLinkListNode head;
	public SingleLinkListNode current;

	// 方法：向链表中添加数据
	public void add(int data) {
		// 判断链表为空的时候
		if (head == null) {// 如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
			head = new SingleLinkListNode(data);
			current = head;
		} else {
			// 创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			current.next = new SingleLinkListNode(data);
			// 把链表的当前索引向后移动一位
			current = current.next; // 此步操作完成之后，current结点指向新添加的那个结点
		}
	}

	// 方法：向链表中添加数据
	public void add(int[] data) {
		// 判断链表为空的时候
		for (int i = 0; i < data.length; i++) {
			if (head == null) {// 如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
				head = new SingleLinkListNode(data[i]);
				current = head;
			} else {
				// 创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
				current.next = new SingleLinkListNode(data[i]);
				// 把链表的当前索引向后移动一位
				current = current.next; // 此步操作完成之后，current结点指向新添加的那个结点
			}
		}
	}

	// 方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
	public void print(SingleLinkListNode node) {
		if (node == null) {
			return;
		}

		current = node;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

}
