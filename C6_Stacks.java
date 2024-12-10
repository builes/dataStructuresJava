import java.util.Arrays;
import java.util.Stack;

public class C6_Stacks {
    public static void main(String[] args) {
        // Create a new Stack instance
        Stack<String> stack = new Stack<>();

        // push() - Adds elements to the top of the stack
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");
        System.out.println("Stack after push operations: " + stack);

        // peek() - Retrieves the element at the top of the stack without removing it
        String topElement = stack.peek();
        System.out.println("Element at the top (peek): " + topElement);

        // pop() - Removes and returns the element at the top of the stack
        String poppedElement = stack.pop();
        System.out.println("Element removed (pop): " + poppedElement);
        System.out.println("Stack after pop operation: " + stack);

        // isEmpty() - Checks if the stack is empty
        boolean emptyStatus = stack.isEmpty();
        System.out.println("Is the stack empty? " + emptyStatus);

        // search(Object o) - Searches for an element and returns its position from the top
        // The position is 1-based (top element has position 1)
        int position = stack.search("Element 1");
        System.out.println("Position of 'Element 1' from the top: " + position);

        // size() - Returns the number of elements in the stack
        int stackSize = stack.size();
        System.out.println("Current stack size: " + stackSize);


        //Array stack
        // Create a stack with a size of 5
        ArrayStack stack1 = new ArrayStack(5);

        // Push elements onto the stack
        stack1.push(10);  // Adds 10 to the stack
        stack1.push(20);  // Adds 20 to the stack
        stack1.push(30);  // Adds 30 to the stack    }
    }
}

// Implementing an stack with an array
class ArrayStack {
    private int[] stack;  // Array to store stack elements
    private int top;      // Top of the stack (index of the top element, makes reference to the index of the last element)

    // Constructor to initialize the stack with a fixed size
    public ArrayStack(int size) {
        stack = new int[size];  // Create an array of the given size
        top = -1;               // Initialize top to -1, indicating an empty stack
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int value) {
        if (top == stack.length - 1) {  // Check if the stack is full
            System.out.println("Stack is full! Can't push.");
        } else {
            stack[++top] = value;  // Increment top and add the value
            System.out.println(value + " added to the ArrayStack.");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Can't pop.");
            return -1;  // Stack underflow
        } else {
            int poppedValue = stack[top--];  // Return the top element and decrement top
            System.out.println("Popped element: " + poppedValue);
            return poppedValue;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty! No elements to peek.");
            return -1;  // Stack underflow
        } else {
            System.out.println("Top element: " + stack[top]);
            return stack[top];  // Return the element at the top index
        }
    }
}


// Implementing the stack with a linkedlist
class LinkedListStack {
    private Node top;  // Top of the stack

    // Node class for the linked list
    private class Node {
        int data;
        Node next;
    }

    // Constructor
    public LinkedListStack() {
        this.top = null;
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;  // Point new node to current top
        top = newNode;       // Update top to the new node
        System.out.println(value + " added to the LinkedListStack.");
    }

    public int pop() {
        if (top == null) { // Check if the stack is empty
            System.out.println("Stack is empty! Can't pop.");
            return -1;  // Stack underflow
        } else {
            int poppedValue = top.data;  // Store the top element's data
            top = top.next;  // Move top to the next node
            System.out.println("Popped element: " + poppedValue);
            return poppedValue;
        }
    }

    public int peek() {
        if (top == null) { // Check if the stack is empty
            System.out.println("Stack is empty! No elements to peek.");
            return -1;  // Stack underflow
        } else {
            System.out.println("Top element: " + top.data);
            return top.data;  // Return the element at the top
        }
    }
}


