public class C5_DoubleLinkedList {
    public static void main(String[] args) {
        // Creating a new double-linked list
        LinkedList1 lst = new LinkedList1();

        // Adding nodes to the end of the list
        lst.addingAtTheEnd(1);
        lst.addingAtTheEnd(2);
        lst.addingAtTheEnd(3);
        lst.addingAtTheEnd(5);
        lst.addingAtTheEnd(6);

        // Adding a node at a specific position in the list
        lst.addingAtSpecificPosition(4, 3);

        // Removing the head node and traversing the list forward
        lst.removinghead();
        lst.traverseForward();
    }
}

class Node1 {
    int data;      // Value of the node
    Node1 next;    // Pointer to the next node in the list
    Node1 prev;    // Pointer to the previous node in the list

    // Constructor to initialize node data and set pointers to null
    Node1(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class LinkedList1 {

    Node1 head; // Reference to the first node (head) of the list
    Node1 tail; // Reference to the last node (tail) of the list

    // Method to add a node to the end of the list
    void addingAtTheEnd(int data) {
        Node1 newNode = new Node1(data); // Creating a new node
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, link the current tail to the new node and update the tail
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to add a node at a specific position in the list
    void addingAtSpecificPosition(int data, int index) {
        Node1 newNode = new Node1(data);
        if (index == 0) {
            // Insert at the beginning of the list
            if (head == null) {
                // If the list is empty, set both head and tail to the new node
                head = newNode;
                tail = newNode;
            } else {
                // If list is not empty, link the new node to the current head
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }

        // Insert at a specific position or end of the list
        int counter = 0;
        Node1 current = head;

        // Traverse until the desired position or the end of the list
        while (current != null && counter < index) {
            current = current.next;
            counter++;
        }

        if (current == null) {
            // If index is out of bounds, insert at the end
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            // Insert in the middle of the list
            current.prev.next = newNode; // Link previous node to the new node
            newNode.prev = current.prev; // Link new node to previous node
            newNode.next = current;      // Link new node to current node
            current.prev = newNode;      // Link current node back to new node
        }
    }

    // Method to traverse the list backward (from tail to head)
    void traverseBackward() {
        Node1 current = tail;
        while (current != null) {
            if (current.prev != null) {
                System.out.printf("data: %d points to -> %d\n", current.data, current.prev.data);
            } else {
                System.out.printf("data: %d points to -> null\n", current.data);
            }
            current = current.prev; // Move to the previous node
        }
    }

    // Method to traverse the list forward (from head to tail)
    void traverseForward() {
        Node1 current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.printf("data: %d points to -> %d\n", current.data, current.next.data);
            } else {
                System.out.printf("data: %d points to -> null\n", current.data);
            }
            current = current.next; // Move to the next node
        }
    }

    // Method to remove the head (first) node of the list
    void removinghead() {
        if (head == null) {
            // If the list is empty, return
            return;
        }
        head = head.next; // Set the head to the next node
        if (head != null) {
            // If the list is not empty after removing, set head's prev to null
            head.prev = null;
        } else {
            // If the list is now empty, also set tail to null
            tail = null;
        }
    }

    // Method to remove the tail (last) node of the list
    void removingTail() {
        if (tail == null) {
            // If the list is empty, return
            return;
        }
        tail = tail.prev; // Set the tail to the previous node
        if (tail != null) {
            // If the list is not empty after removing, set tail's next to null
            tail.next = null;
        } else {
            // If the list is now empty, also set head to null
            head = null;
        }
    }
}
