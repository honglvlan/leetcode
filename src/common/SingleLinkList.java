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

	// ���������������������
	public void add(int data) {
		// �ж�����Ϊ�յ�ʱ��
		if (head == null) {// ���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
			head = new SingleLinkListNode(data);
			current = head;
		} else {
			// �����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
			current.next = new SingleLinkListNode(data);
			// ������ĵ�ǰ��������ƶ�һλ
			current = current.next; // �˲��������֮��current���ָ������ӵ��Ǹ����
		}
	}

	// ���������������������
	public void add(int[] data) {
		// �ж�����Ϊ�յ�ʱ��
		for (int i = 0; i < data.length; i++) {
			if (head == null) {// ���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
				head = new SingleLinkListNode(data[i]);
				current = head;
			} else {
				// �����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
				current.next = new SingleLinkListNode(data[i]);
				// ������ĵ�ǰ��������ƶ�һλ
				current = current.next; // �˲��������֮��current���ָ������ӵ��Ǹ����
			}
		}
	}

	// ����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
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
