package AddTowNumbers;

import common.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] a = {2, 4, 3};
        int[] b = {5, 6, 4};
        SingleLinkedList list1 = new SingleLinkedList(a);
        ListNode node = list1.getHead();

        while (node != null)
        {
            System.out.printf("%d", node.getValue());
            node = node.getNext();
        }

    }
}
