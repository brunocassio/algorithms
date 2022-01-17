package singlylinkedlist;

/**
 *  An object for storing a single node in a linked list
 *
 *     Attributes:
 *         data: Data stored in node
 *         next_node: Reference to next node in linked list
 */
public class Node {

    private Integer data;
    private Node next_node;

    public Node(Integer data, Node next_node) {
        this.data = data;
        this.next_node = next_node;
    }

    public Node(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "<Node data: " + getData() + ">";
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext_node() {
        return next_node;
    }

    public void setNext_node(Node next_node) {
        this.next_node = next_node;
    }
}
