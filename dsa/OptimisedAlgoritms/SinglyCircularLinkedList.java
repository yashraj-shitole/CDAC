
// Time Complexity:
// Insertion at the beginning or end: O(1)
// Deletion from the beginning or end: O(n) for deleteLast(), 𝑂(1) O(1) for deleteFirst()

// Definition for a Node in the circular linked list
class Node {
    int data;
    Node next;

    // Constructor for Node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Definition for the CircularLinkedList class
public class SinglyCircularLinkedList {
    private Node tail; // Tail node points to the last node in the list
    private int size;  // To keep track of the number of elements

    // Constructor for the CircularLinkedList
    public SinglyCircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    // Method to add a node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Points to itself, making it circular
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    // Method to add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Points to itself, making it circular
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode; // Update the tail to the new last node
        }
        size++;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        if (tail.next == tail) { // Only one node in the list
            tail = null;
        } else {
            tail.next = tail.next.next; // Bypass the current head
        }
        size--;
    }

    // Method to delete the last node
    public void deleteLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        if (tail.next == tail) { // Only one node in the list
            tail = null;
        } else {
            Node current = tail.next;
            while (current.next != tail) { // Traverse until the second-last node
                current = current.next;
            }
            current.next = tail.next; // Point second-last node to the head
            tail = current; // Update the tail to the new last node
        }
        size--;
    }

    // Method to display the linked list
    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail.next; // Start from the head
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println("(back to head)");
    }

    // Method to get the size of the linked list
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.display(); // Output: 10 -> 20 -> 30 -> (back to head)

        list.deleteFirst();
        list.display(); // Output: 20 -> 30 -> (back to head)

        list.deleteLast();
        list.display(); // Output: 20 -> (back to head)

        System.out.println("Size of the list: " + list.getSize()); // Output: 1
    }
}
