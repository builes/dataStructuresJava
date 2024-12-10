import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class C9_HashMap {

    public static void main(String[] args) {
        // Create a HashMap instance
        HashMap<String, Integer> map = new HashMap<>();

        // ============================
        // Adding Elements with put()
        // ============================
        map.put("Alice", 30);  // Adds entry with key "Alice" and value 30
        map.put("Bob", 25);    // Adds entry with key "Bob" and value 25
        map.put("Charlie", 35); // Adds entry with key "Charlie" and value 35

        // If the key already exists, put() will replace the old value with the new value
        map.put("Alice", 32); // Updates Alice's age to 32

        System.out.println("Map after additions: " + map);

        // ==================================
        // Retrieving Elements with get()
        // ==================================
        // The get() method retrieves a value by its key
        System.out.println("Age of Alice: " + map.get("Alice")); // Output: 32
        System.out.println("Age of Bob: " + map.get("Bob")); // Output: 25

        // If the key is not in the map, get() returns null
        System.out.println("Age of Eve: " + map.get("Eve")); // Output: null

        // ======================================
        // Checking for Keys and Values
        // ======================================
        // containsKey() checks if a key exists in the map
        if (map.containsKey("Charlie")) {
            System.out.println("Map contains key 'Charlie'");
        }

        // containsValue() checks if a value exists in the map
        if (map.containsValue(32)) {
            System.out.println("Map contains value 32");
        }

        // ===============================
        // Removing Elements with remove()
        // ===============================
        // remove() removes an entry by its key
        map.remove("Bob"); // Removes entry with key "Bob"
        System.out.println("Map after removing Bob: " + map);

        // remove() returns the removed value, or null if key was not found
        Integer removedValue = map.remove("Eve"); // Key "Eve" does not exist
        System.out.println("Removed value for key 'Eve': " + removedValue); // Output: null

        // ===============================
        // Replacing Values with replace()
        // ===============================
        // replace() updates the value for an existing key
        map.replace("Alice", 28); // Updates Alice's age to 28
        System.out.println("Map after replacing Alice's age: " + map);

        // replace() can also conditionally replace a value if it matches a given value
        boolean isReplaced = map.replace("Charlie", 35, 40); // Changes 35 to 40 for "Charlie"
        System.out.println("Was Charlie's age replaced? " + isReplaced);
        System.out.println("Map after conditional replacement: " + map);

        // ===============================
        // Iterating Over the Map Entries
        // ===============================

        // ---- Using entrySet() ----
        // entrySet() returns a set of all key-value pairs as Map.Entry objects
        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Explanation:
        // entrySet() allows iterating directly over the key-value pairs (entries).
        // Each entry is a Map.Entry object with methods getKey() and getValue() to access
        // the key and value respectively.

        // ---- Using keySet() ----
        // keySet() returns a set of all keys in the map
        System.out.println("\nIterating using keySet():");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Explanation:
        // keySet() allows iterating over the keys in the map.
        // Each key can be used with get() to retrieve the corresponding value.

        // ---- Using values() ----
        // values() returns a collection of all values in the map
        System.out.println("\nIterating using values():");
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        // Explanation:
        // values() allows iterating directly over all values in the map,
        // without the need to reference their keys.

        // ===============================
        // Understanding Map.Entry in detail
        // ===============================

        // Map.Entry is a nested interface within the Map interface.
        // Each entry represents a key-value pair in the map.
        // The entrySet() method provides a set of Map.Entry objects representing all entries.
        // Map.Entry methods:
        // - getKey(): retrieves the key of the entry
        // - getValue(): retrieves the value of the entry
        // - setValue(): sets a new value for the entry (used in modification)

        // ---- Modifying Entries via entrySet() ----
        System.out.println("\nModifying entries using entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals("Alice")) {
                entry.setValue(29); // Directly update Alice's age to 29
            }
            System.out.println("Updated Entry - Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("Map after modification: " + map);

        // ===============================
        // Additional Operations
        // ===============================

        // ---- size() method ----
        // Returns the number of entries in the map
        System.out.println("\nSize of map: " + map.size());

        // ---- isEmpty() method ----
        // Checks if the map is empty
        System.out.println("Is map empty? " + map.isEmpty());

        // ---- clear() method ----
        // Removes all entries from the map
        map.clear();
        System.out.println("Map after clear(): " + map);
    }
}
