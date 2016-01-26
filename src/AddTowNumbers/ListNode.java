package AddTowNumbers;

// Definition for singly-linked list.
public class ListNode {
    private int val;
    private ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public ListNode(int x, ListNode next) {
        val = x;
        next = next;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        val = val;
    }


    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        next = next;
    }
}