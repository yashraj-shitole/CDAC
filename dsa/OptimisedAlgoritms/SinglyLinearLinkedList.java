// Time complexity for insertion and deletion is O(n) in the worst case but O(1) for operations at the head.


// Definition for a Node in the singly linked list
class Node {
    int data;
    Node next;

    // Constructor for Node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Definition for the LinkedList class
public class SinglyLinearLinkedList {
    private Node head;
    private int size; // To keep track of the number of elements

    // Constructor for the LinkedList
    public SinglyLinearLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add a node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Method to add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        size--;
    }

    // Method to delete the last node
    public void deleteLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
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
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to get the size of the linked list
    public int getSize() {
        return size;
    }

    // Method to search for an element
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinearLinkedList list = new SinglyLinearLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.insertAt(1, 15);
        list.display(); // Output: 10 -> 15 -> 20 -> 30 -> null

        list.deleteAt(1);
        list.display(); // Output: 10 -> 20 -> 30 -> null

        list.deleteFirst();
        list.display(); // Output: 20 -> 30 -> null

        list.deleteLast();
        list.display(); // Output: 20 -> null

        System.out.println("List contains 20: " + list.contains(20)); // Output: true
        System.out.println("Size of the list: " + list.getSize()); // Output: 1
    }
}
