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
        linkedList.insert(24, 2);
        System.out.println("size: " + linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.search(23));
        System.out.println("List is empty: " + linkedList.isEmpty());
        System.out.println("Removing one node...");
        linkedList.remove(2);
        System.out.println(linkedList);

    }

    /**
     * Removes Node containing data that matches the key
     * Returns the node or `None` if key doesn't exist
     * Takes O(n) time
     * @param key
     * @return
     */
    public Node remove(int key) {
        Node current = this.head;
        Node previous = new Node();
        boolean found = false;

        while (current != null && !found) {
            if (current.getData() == key && current == this.head) {
                found = true;
                this.head = current.getNext_node();
                this.count --;
                return current;
            } else if (current.getData() == key) {
                found = true;
                previous.setNext_node(current.getNext_node());
                this.count --;
                return current;
            } else {
                previous = current;
                current = current.getNext_node();
            }
        }
        return null;
    }

    /**
     * Inserts a new Node containing data at index position
     * Insertion takes O(1) time but finding node at insertion point takes
     * O(n) time.
     * Takes overall O(n) time.
     * @param data
     * @param index
     */
    public void insert(Integer data, int index) {
        if (index == 0) {
            add(data);
        }

        if (index > 0) {
            Node newNode = new Node(data);
            int position = index;
            Node current = this.head;

            while (position > 1) {
                current = current.getNext_node();
                position --;
            }

            Node prev = current;
            Node next = current.getNext_node();

            prev.setNext_node(newNode);
            newNode.setNext_node(next);
        }
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

    /**
     * Search for the first node containing data that matches the key
     * Returns the node or `None` if not found
     * Takes O(n) time
     * @param key
     * @return current
     */
    public Node search(Integer key) {
        Node current = this.head;

        while (current != null) {
            if (current.getData() == key) {
                return current;
            } else {
                current = current.getNext_node();
            }
        }
        return null;
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
