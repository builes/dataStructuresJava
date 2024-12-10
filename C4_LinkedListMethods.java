import java.util.LinkedList;

public class C4_LinkedListMethods {
    public static void main(String[] args) {
        // Create a new LinkedList of String type
        LinkedList<String> list = new LinkedList<>();

        // Adding elements to the LinkedList
        list.add("Alice");            // Adds an element to the end of the list
        list.add("Bob");
        list.add("Charlie");
        System.out.println("Initial list: " + list);

        // Update the element at index 1 (second position) with a new value
        list.set(1, "David"); // Replaces "Bob" with "David"
        System.out.println("After set(1, \"David\"): " + list);

        // Update the element at index 0 (first position)
        list.set(0, "Zara");
        System.out.println("After set(0, \"Zara\"): " + list);

        // Add elements at specific positions
        list.addFirst("Zara");        // Adds an element at the beginning of the list
        list.addLast("Tom");          // Adds an element at the end of the list
        System.out.println("After adding first and last: " + list);

        // Accessing elements in the LinkedList
        String first = list.getFirst();   // Retrieves, but does not remove, the first element
        String last = list.getLast();     // Retrieves, but does not remove, the last element
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);

        // Accessing element at a specific index
        String secondElement = list.get(1);   // Retrieves the element at index 1 (second position)
        System.out.println("Element at index 1: " + secondElement);

        // Removing elements from the LinkedList
        list.removeFirst();      // Removes the first element of the list
        list.removeLast();       // Removes the last element of the list
        System.out.println("After removing first and last: " + list);

        // Removing a specific element by value
        list.remove("Bob");      // Removes the first occurrence of "Bob" in the list
        System.out.println("After removing 'Bob': " + list);

        // Removing an element by index
        list.remove(1);          // Removes the element at index 1
        System.out.println("After removing element at index 1: " + list);

        // Check if the list contains a specific element
        boolean containsAlice = list.contains("Alice");    // Checks if "Alice" is in the list
        System.out.println("List contains 'Alice': " + containsAlice);

        // Get the size of the LinkedList
        int size = list.size();      // Returns the number of elements in the list
        System.out.println("Size of the list: " + size);

        // Iterate through the LinkedList
        System.out.println("Iterating through the list:");
        for (String element : list) {
            System.out.println(element);
        }

        // Clear all elements from the LinkedList
        list.clear();               // Removes all elements from the list
        System.out.println("After clearing the list: " + list);
    }
}
