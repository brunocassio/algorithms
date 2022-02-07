import singlylinkedlist.Node;
import singlylinkedlist.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMergeSort {

    /**
     * Sorts a linked list in ascending order
     * Recursivly divide the linked list into sublists containing a single node
     * Repeatedly merge the sublists to produce sorted sublists until one remains
     * @param linkedList
     * @return sorted linked list
     */
    public SinglyLinkedList mergeSort(SinglyLinkedList linkedList) {
        if (linkedList.size() == 1) {
            return linkedList;
        } else if (linkedList.getHead() == null) {
            return linkedList;
        }

//        SinglyLinkedList leftHalf = split(linkedList);
//        SinglyLinkedList rightHalf = split(linkedList);
        SinglyLinkedList left = mergeSort(leftHalf);
        SinglyLinkedList right = mergeSort(rightHalf);


        return null;
    }

    /**
     * Merges two linked list, sorting by data in nodes
     *
     * @param left
     * @param right
     * @return new merged list
     */
    public SinglyLinkedList merge(SinglyLinkedList left, SinglyLinkedList right) {
        SinglyLinkedList merged = new SinglyLinkedList();
        //Add a fake head that is discarded later
        merged.add(0);
        //Set current to the head of the linked list
        Node current = merged.getHead();
        //Obtain head notes for left and right linked lists
        Node leftHead = left.getHead();
        Node rightHead = right.getHead();
        //Iterate over left and right until we reach the tail node of either
        while (leftHead != null || rightHead != null) {
            //If the head node of left is None, we're at the tail
            // Add the tail node from right to the merged linked list

        }




        return null;
    }

    /**
     * Divide the unsorted list at midpoint into sublists
     * @param linkedList
     * @return
     */
    public List<SinglyLinkedList> split(SinglyLinkedList linkedList) {
        List<SinglyLinkedList> list = new ArrayList<>();
        SinglyLinkedList leftHalf = null;
        SinglyLinkedList rightHalf;

        if (linkedList == null || linkedList.getHead() == null) {
            leftHalf = linkedList;
            rightHalf = null;
            list.add(leftHalf);
            list.add(rightHalf);
            return list;
        } else {
            int size = linkedList.size();
            int mid = size / 2;
            Node midNode = linkedList.nodeAtIndex(mid - 1);
            leftHalf = linkedList;
            rightHalf = new SinglyLinkedList();
            rightHalf.setHead(midNode.getNext_node());
            midNode.setNext_node(null);
            list.add(leftHalf);
            list.add(rightHalf);
            return list;
        }
    }
}
