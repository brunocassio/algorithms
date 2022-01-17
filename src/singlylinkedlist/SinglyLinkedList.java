package singlylinkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 Linear data structure that stores values in nodes.
 The list maintains a reference to the first node, also called head.
 Each node points to the next node in the list

 Attributes:
 head: The head node of the list
 */
public class SinglyLinkedList {

    private Node head;
    private int count;

    public SinglyLinkedList(Node head, int count) {
        this.head = head;
        this.count = count;
    }

    public SinglyLinkedList() {
    }

    public static void main(String[] args) {
        Node nextNode = new Node(2, null);
        Node node = new Node(1, nextNode);
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(23);
        System.out.println("size: " + linkedList.size());
        System.out.println(linkedList);
    }

    /**
     * Determines if the linked list is empty
     * Takes O(1) time
     * @return true if the linked list is empty
     */
    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    public int size() {
        Node current = this.head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.getNext_node();
        }

        return count;
    }

    /**
     * Adds new Node containing data at head of the list
     * Takes O(1) time
     * @param data
     */
    public void add(Integer data) {
        Node newNode = new Node(data);
        newNode.setNext_node(this.head);
        this.head = newNode;
    }

    @Override
    public String toString() {
        List<String> nodes = new ArrayList<>();
        Node current = this.head;

        while (current != null) {
            if (current == this.head) {
                nodes.add(String.format("[Head: %d]", current.getData()));
            } else if (current.getNext_node() == null) {
                nodes.add(String.format("[Tail: %d]", current.getData()));
            } else {
                nodes.add(String.format("[%d]", current.getData()));
            }
            current = current.getNext_node();
        }
        String result = String.join("->", nodes);
        return result;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
