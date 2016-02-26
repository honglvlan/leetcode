package common;

public class SingleLinkListNode {
	// 注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
	public int data; // 数据域
	public SingleLinkListNode next;// 指针域

	public SingleLinkListNode(int data) {
		this.data = data;
	}
}