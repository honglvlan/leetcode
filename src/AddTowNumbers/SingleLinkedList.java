package AddTowNumbers;

import common.ListNode;

public class SingleLinkedList {
    private ListNode head;

    public SingleLinkedList() {
        head = null;
    }



    public SingleLinkedList(int[] values) {
        for (int i = 0; i < values.length; i ++) {
            ListNode node = new ListNode(values[i]);
            this.add(node);
        }
    }

    public ListNode getHead()
    {
        return head;
    }


    public void add (ListNode node) {

        if (head == null)
            head = node;
        else
        {
            ListNode curr = head;
            while (curr.getNext() != null)
            {
                curr = curr.getNext();
            }
            curr.setNext(node);
        }
    }
}