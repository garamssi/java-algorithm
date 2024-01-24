package practice;

public class LinkedListSample<E> {

    Node node;

    public class Node {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void append(E value) {
        Node node = new Node(value);
        if(this.node == null) {
            this.node = node;
        }else {
            Node currNode = this.node;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
    }

    public static void main(String[] args) {
//        java.util.LinkedList<Integer> linkedList1 = new java.util.LinkedList<>();
//        linkedList1.add(1);
//        linkedList1.add(2);
//        linkedList1.add(3);
//        linkedList1.add(4);

        LinkedListSample<Integer> linkedList = new LinkedListSample<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

    }


}
