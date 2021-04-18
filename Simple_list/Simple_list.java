package Simple_list;


public class Simple_list {

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


    public static Simple_list insert(Simple_list list, int data)
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



    public static void printList(Simple_list list)
    {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    public static Simple_list deleteByKey(Simple_list list, int key)
    {
        Node currNode = list.head, prev = null;
        Node Nodeforswap1, Nodeforswap2 , prevNode1, prevNode2;


        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;

            System.out.println(key + " found and deleted");

            Nodeforswap1 = list.head;
            Nodeforswap2 = currNode.next.next;
            prevNode1 = null;
            prevNode2 = list.head;


            if (Nodeforswap1 != null && Nodeforswap2 != null) {

                if (prevNode1 != null)
                    prevNode1.next = Nodeforswap2;
                else
                    list.head = Nodeforswap2;

                if (prevNode2 != null)
                    prevNode2.next = Nodeforswap1;
                else
                    list.head = Nodeforswap1;

                Node temp = Nodeforswap1.next;
                Nodeforswap1.next = Nodeforswap2.next;
                Nodeforswap2.next = temp;
            }

            return list;
        }


        while (currNode != null && currNode.data != key) {

            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {

            prev.next = currNode.next;

            System.out.println(key + " found and deleted");

            Nodeforswap1 = currNode.next;
            Nodeforswap2 = currNode.next.next;
            prevNode1 = prev;
            prevNode2 = currNode.next;;


            if (Nodeforswap1 != null && Nodeforswap2 != null) {

                if (prevNode1 != null)
                    prevNode1.next = Nodeforswap2;
                else
                    list.head = Nodeforswap2;

                if (prevNode2 != null)
                    prevNode2.next = Nodeforswap1;
                else
                    list.head = Nodeforswap1;

                Node temp = Nodeforswap1.next;
                Nodeforswap1.next = Nodeforswap2.next;
                Nodeforswap2.next = temp;
            }
        }


        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }


    public static Simple_list deleteAtPosition(Simple_list list, int index)
    {
        Node currNode = list.head, prev = null;
        Node Nodeforswap1, Nodeforswap2 , prevNode1, prevNode2;


        if (index == 0 && currNode != null) {
            list.head = currNode.next;

            System.out.println(
                    index + " position element deleted");

            Nodeforswap1 = list.head;
            Nodeforswap2 = currNode.next.next;
            prevNode1 = null;
            prevNode2 = list.head;


            if (Nodeforswap1 != null && Nodeforswap2 != null) {

                if (prevNode1 != null)
                    prevNode1.next = Nodeforswap2;
                else
                    list.head = Nodeforswap2;

                if (prevNode2 != null)
                    prevNode2.next = Nodeforswap1;
                else
                    list.head = Nodeforswap1;

                Node temp = Nodeforswap1.next;
                Nodeforswap1.next = Nodeforswap2.next;
                Nodeforswap2.next = temp;
            }

            return list;
        }

        int counter = 0;

        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                System.out.println(
                        index + " position element deleted");

                Nodeforswap1 = currNode.next;
                Nodeforswap2 = currNode.next.next;
                prevNode1 = prev;
                prevNode2 = currNode.next;;


                if (Nodeforswap1 != null && Nodeforswap2 != null) {

                    if (prevNode1 != null)
                        prevNode1.next = Nodeforswap2;
                    else
                        list.head = Nodeforswap2;

                    if (prevNode2 != null)
                        prevNode2.next = Nodeforswap1;
                    else
                        list.head = Nodeforswap1;

                    Node temp = Nodeforswap1.next;
                    Nodeforswap1.next = Nodeforswap2.next;
                    Nodeforswap2.next = temp;
                }
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(
                    index + " position element not found");
        }

        return list;
    }

    public static void main(String[] args)
    {
        Simple_list list = new Simple_list();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printList(list);

        deleteByKey(list, 1);

        printList(list);

        deleteByKey(list, 4);

        printList(list);

        deleteByKey(list, 10);

        printList(list);

        deleteAtPosition(list, 0);

        printList(list);

        deleteAtPosition(list, 2);

        printList(list);

        deleteAtPosition(list, 10);

        printList(list);
    }
}