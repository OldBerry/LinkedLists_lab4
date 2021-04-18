package Insert_in_mid_of_simple_list;

public class LinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }
        else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        return list;
    }

    static void insertAtMid(LinkedList list, int x)
    {
        if (list.head == null)
            list.head = new Node(x);
        else {
            Node newNode = new Node(x);

            Node ptr = list.head;
            int len = 0;

            while (ptr != null) {
                len++;
                ptr = ptr.next;
            }

            int count = ((len % 2) == 0) ? (len / 2) :
                    (len + 1) / 2;
            ptr = list.head;

            while (count-- > 1)
                ptr = ptr.next;

            newNode.next = ptr.next;
            ptr.next = newNode;
        }
    }

    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null) {

            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
        System.out.println("\n");
    }


    public static void main(String[] args)
    {
        LinkedList listo = new LinkedList();

        listo = insert(listo, 1);
        listo = insert(listo, 2);
        listo = insert(listo, 3);
        listo = insert(listo, 4);
        listo = insert(listo, 5);
        listo = insert(listo, 6);
        listo = insert(listo, 7);
        listo = insert(listo, 8);

        printList(listo);

        insertAtMid(listo, 0);
        insertAtMid(listo, 0);
        insertAtMid(listo, 0);
        insertAtMid(listo, 0);


        printList(listo);

    }
}