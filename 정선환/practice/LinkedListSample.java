package practice;

public class LinkedListSample<E> {

    Node head;

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

    public E get(int index) {
        Node currNode = head;
        for(int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.value;
    }

    public void append(E value) {
        Node node = new Node(value);
        if(this.head == null) {
            this.head = node;
        }else {
            Node currNode = this.head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
    }

    public void insert(int index, E value) {
        Node insertNode = new Node(value);
        if(index == 0) {
            insertNode.next = this.head;
            this.head = insertNode;
        }else {
            Node currNode = head;
            for(int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }

            Node nextNode = currNode.next;
            currNode.next = insertNode;
            insertNode.next = nextNode;
        }
    }

    public void remove(int index) {
        Node currNode = this.head;
        for(int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }

        Node nextNode = currNode.next.next;
        currNode.next = nextNode;
    }

    public static void main(String[] args) {
        LinkedListSample<Integer> linkedList = new LinkedListSample<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        linkedList.insert(0, 9);
        linkedList.remove(1);

    }


}
