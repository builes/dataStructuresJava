import java.util.Map;
import java.util.LinkedHashMap;

public class C10_LinkedHashMap {

    // Main method to demonstrate LinkedHashMap operations
    public static void main(String[] args) {

        // Creating a LinkedHashMap that stores String keys and Integer values
        // Default capacity of 16 and load factor of 0.75, insertion order is maintained by default
        Map<String, Integer> map = new LinkedHashMap<>();

        // 1. Inserting elements into the LinkedHashMap
        System.out.println("Inserting elements into the map...");
        map.put("Apple", 10); // Adds a key-value pair ("Apple", 10)
        map.put("Banana", 20); // Adds a key-value pair ("Banana", 20)
        map.put("Cherry", 30); // Adds a key-value pair ("Cherry", 30)
        map.put("Date", 40);   // Adds a key-value pair ("Date", 40)
        map.put("Elderberry", 50); // Adds a key-value pair ("Elderberry", 50)

        // 2. Printing the map after insertion
        // The map should maintain the insertion order of the keys
        System.out.println("Map after insertion: " + map);

        // 3. Retrieving elements by key using get() method
        // If the key is not found, get() returns null
        System.out.println("\nRetrieving elements:");
        System.out.println("Apple's value: " + map.get("Apple"));  // Should return 10
        System.out.println("Banana's value: " + map.get("Banana")); // Should return 20
        System.out.println("Grape's value: " + map.get("Grape"));   // Should return null (key does not exist)

        // 4. Checking if a specific key exists in the map using containsKey()
        // If the key exists, containsKey() returns true, otherwise false
        System.out.println("\nChecking if 'Cherry' exists in the map: " + map.containsKey("Cherry")); // Should return true
        System.out.println("Checking if 'Grape' exists in the map: " + map.containsKey("Grape"));   // Should return false

        // 5. Removing an element by key using remove()
        // If the key is found, remove() returns the value associated with that key and removes the entry
        // If the key is not found, it returns null and no changes are made
        System.out.println("\nRemoving 'Date' from the map...");
        System.out.println("Removed value: " + map.remove("Date")); // Should return 40 and remove the entry

        // 6. Printing the map after removal
        // The map should no longer contain the "Date" entry
        System.out.println("Map after removing 'Date': " + map);

        // 7. Iterating over the LinkedHashMap using entrySet() and for-each loop
        // entrySet() returns a set of key-value pairs, and we can iterate over them
        System.out.println("\nIterating over the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 8. Checking the size of the map using size() method
        // Returns the number of key-value pairs in the map
        System.out.println("\nSize of the map: " + map.size()); // Should return the size of the map after removal

        // 9. Clearing all elements from the map using clear()
        // Removes all entries from the map and the map becomes empty
        System.out.println("\nClearing all elements...");
        map.clear();

        // 10. Printing the map after clearing
        // The map should be empty now
        System.out.println("Map after clearing: " + map);

        // 11. Checking if the map is empty using isEmpty()
        // Returns true if the map contains no key-value pairs, otherwise false
        System.out.println("\nIs the map empty? " + map.isEmpty()); // Should return true since the map is cleared
    }
}

