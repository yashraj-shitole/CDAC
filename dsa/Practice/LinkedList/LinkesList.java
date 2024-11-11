public class LinkesList {

    Node head;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }


        

    }

    public void addAtFirst(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int value) {

        Node temp = head;
        Node newNode = new Node(value);

        while (temp.next != null) {
            temp = temp.next;
        }

        
        temp.next = newNode;

    }

    public void addAtPosition(int position, int value) {

        
        Node newNode = new Node(value);

        if (head.next == null) {
            head=newNode;
        }
        else if(position<=1){
            addAtFirst(value);
        }
        else{
            Node temp = head;
        for (int i = 1; i < position && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        }
    }

    public void deleteFirst() {

        if (head != null)
            head = head.next;
    }

    public void deleteLast() {

        Node temp = head;

        if (head == null) {
            return;
        }

        if (head.next == null) {
            return;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public void deleteAtPosition(int position) {

        Node temp = head;

        for (int i = 0; i < position && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }
        temp.next = temp.next.next;

    }

    public void display() {

        Node temp = head;

        if (head == null) {
            return;
        }
        int i=1;
        while (temp != null) {
            System.out.println(i+") "+temp.data);
            temp = temp.next;
            i++;
        }

    }

    public void search() {

    }

}

class MainLL {

    public static void main(String[] args) {

        LinkesList ll = new LinkesList();

        ll.addAtFirst(100);
        ll.addAtFirst(200);
        ll.addAtFirst(300);

        ll.display();

        ll.addLast(400);
        ll.addLast(6000);

        ll.addAtPosition(4, 700);

        System.out.println();
        
        ll.display();
        
        System.out.println();
        
        ll.deleteFirst();
        ll.display();
        System.out.println();
        
        ll.deleteAtPosition(2);
        ll.display();
        System.out.println();

        ll.deleteLast();
        ll.display();
        System.out.println(ll.head.toString());
    }
}