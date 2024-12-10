import java.util.Scanner;

public class C3_LinkedList {
    public static void main(String[] args) {
        LinkedList waitlist = new LinkedList();
        waitlist.addCustomer("Alice", "Party of 2");
        waitlist.addCustomer("Bob", "Party of 3");
        waitlist.addCustomer("Smitha", "Party of 4");

//        waitlist.removeCustomer("Bob");
        waitlist.updateCustomer("Alice", "Reservation for 4");
        waitlist.addCustomer("Diana", "Reservation for 4");
        waitlist.addCustomer("Mauricio", "Reservation for 2", false);
        waitlist.addCustomer("Juan", "Reservation for 2", true);

        //waitlist.addCustomer("Caro", "Party of 2");
        waitlist.printList();
    }
}


/*The first step in building a linked list is to define the node
Each node contains data; in this case, it stores the customer’s name and details.
The next reference points to the next customer in line, creating a chain of nodes that forms the linked list.*/
class Node {
    String name; // The customer's name
    String details; // Additional details
    boolean isVIP;

    Node next; // Reference to the next customer in line

    Node(String name, String details){
        this.name = name;
        this.details = details;
        this.isVIP = false;
    }

    Node(String name, String details, boolean isVIP){
        this.name = name;
        this.details = details;
        this.isVIP = isVIP;
    }
}

class LinkedList{
    Node head; //

    LinkedList(){
        this.head = null;
    }


    void addCustomer(String name, String details, boolean isVIP){

        if(!isVIP){
            addCustomer(name, details);
            return;
        }
        Node newNode = new Node(name, details, isVIP);
        if (head == null){
            // If the list is empty, the new customer becomes the head
            head = newNode;
        }else if (isVIP && !head.isVIP) {
            // Si el nuevo cliente es VIP y el head actual no lo es, el nuevo cliente VIP se convierte en el head
            newNode.next = head;
            head = newNode;
        } else{
            Node current = head;
            while (current.next != null && current.next.isVIP){
                current = current.next;
            }
            Node aux = current.next; // With this we save the reference to the node
            current.next = newNode;
            newNode.next = aux;
        }
    }

    void addCustomer(String name, String details){
        Node newNode = new Node(name, details);

        if (head == null){
            // If the list is empty, the new customer becomes the head
            head = newNode;
        }else {
            Node current = head;
            // Traverse to the end of the list
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove a specific customer from the waitlist
    void removeCustomer(String customerName){
        if(head == null) return; // If the waitlist is empty, there's nothing to remove

        //if the customer to remove is the head of the list
        if(head.name.equals(customerName)){
            this.head = head.next; // Move the head to the next customer
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.name.equals(customerName)){
            current = current.next;
        }
        if (current.next != null){
            System.out.println("elemento borrado");
            current.next = current.next.next;
        }

    }

    void updateCustomer(String name, String details){
        if( head == null) return; // If the waitlist is empty, there's nothing to update

        Node current = head;
        while (current != null){
            if(current.name.equals(name)){
                current.details = details;
                return;
            }
            current = current.next;
        }
    }

    // Method to print the linked list
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " (" + current.details + ")");
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> null");
    }
}