// Time Complexity:
// Insertions and deletions at the start and end: O(1)
// Insertions and deletions at specific positions: O(n) in the worst case


// Definition for a Node in the doubly linked list
class Node {
    int data;
    Node next;
    Node prev; // Pointer to the previous node

    // Constructor for Node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Definition for the DoublyLinearLinkedList class
public class DoublyLinearLinkedList {
    private Node head;
    private Node tail; // Tail node for efficient end operations
    private int size;  // To keep track of the number of elements

    // Constructor for the DoublyLinearLinkedList
    public DoublyLinearLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add a node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Method to insert a node at a specific position
    public void insertAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Method to delete the last node
    public void deleteLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Method to delete a node at a specific position
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    // Method to display the linked list from head to tail
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print("| "+current.data + " |->");
            current = current.next;
        }
        System.out.println("| null |");
    }

    // Method to display the linked list from tail to head
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print("| "+current.data + " |->");
            current = current.prev;
        }
        System.out.println("| null |");
    }

    // Method to get the size of the linked list
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinearLinkedList list = new DoublyLinearLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.insertAt(1, 15);
        list.displayForward(); // Output: 10 -> 15 -> 20 -> 30 -> null

        list.deleteAt(2);
        list.displayForward(); // Output: 10 -> 15 -> 30 -> null

        list.displayBackward(); // Output: 30 -> 15 -> 10 -> null

        list.deleteFirst();
        list.displayForward(); // Output: 15 -> 30 -> null

        list.deleteLast();
        list.displayForward(); // Output: 15 -> null

        System.out.println("Size of the list: " + list.getSize()); // Output: 1
    }
}
