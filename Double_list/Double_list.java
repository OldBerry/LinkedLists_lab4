package Double_list;

public class Double_list {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) { data = d; }
    }

    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);

        new_Node.next = head;
        new_Node.prev = null;

        if (head != null)
            head.prev = new_Node;

        head = new_Node;
    }

    public void InsertAfter(Node prev_Node, int new_data)
    {

        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        Node new_node = new Node(new_data);

        new_node.next = prev_Node.next;

        prev_Node.next = new_node;

        new_node.prev = prev_Node;

        if (new_node.next != null)
            new_node.next.prev = new_node;
    }

    void append(int new_data)
    {
        Node new_node = new Node(new_data);

        Node last = head;

        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = new_node;

        new_node.prev = last;
    }

    public void printlist(Node node)
    {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }

    void deleteNode(Node del)
    {

        if (head == null || del == null) {
            return;
        }

        if (head == del) {
            head = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }

        return;
    }

    public static void main(String[] args)
    {
        Double_list dll = new Double_list();

        dll.append(6);
        dll.push(7);
        dll.push(1);
        dll.append(4);
        dll.InsertAfter(dll.head.next, 8);

        System.out.println("List is: ");
        dll.printlist(dll.head);

        dll.deleteNode(dll.head);

        System.out.print("\nList after deleting first node: \n");
        dll.printlist(dll.head);

        dll.deleteNode(dll.head.next);

        System.out.print("\nList after Deleting middle node: \n");
        dll.printlist(dll.head);
    }
}