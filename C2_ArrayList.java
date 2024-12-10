import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class C2_ArrayList {
    public static void main(String[] args) {

        // Declaring an ArrayList without specifying a type
        ArrayList lst = new ArrayList();
        lst.add("ArrayList declaration");  // Adding a String
        lst.add(123); // Adding an Integer
        System.out.println("Basic ArrayList: " + lst);

        // 1. Default Constructor
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("Initialized list1 using default constructor: " + list1);

        // 2. Specifying Initial Capacity
        ArrayList<String> list2 = new ArrayList<>(10);
        System.out.println("Initialized list2 with an initial capacity of 10: " + list2);

        // 3. Using Another Collection
        Collection<String> collection = Arrays.asList("Apple", "Banana", "Cherry");
        ArrayList<String> list3 = new ArrayList<>(collection);
        System.out.println("Initialized list3 from another collection: " + list3);

        // 4. Using Arrays
        String[] array = {"Dog", "Cat", "Fish"};
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList(array));
        System.out.println("Initialized list4 from an array: " + list4);

        // 5. Using Anonymous Inner Class
        ArrayList<String> list5 = new ArrayList<String>() {{
            add("Red");
            add("Green");
            add("Blue");
        }};
        System.out.println("Initialized list5 using anonymous inner class: " + list5);

        // 7. Adding elements
        list1.add("First Element"); // O(1) amortized
        list1.add("Second Element");
        System.out.println("After adding elements to list1: " + list1);

        // 8. Inserting at a specific index
        list1.add(1, "Inserted Element"); // O(n)
        System.out.println("After inserting an element in list1: " + list1);

        // 9. Getting an element
        String element = list1.get(1); // O(1)
        System.out.println("Element at index 1 in list1: " + element);

        // 10. Setting an element
        list1.set(1, "Updated Element"); // O(1)
        System.out.println("After updating the element in list1: " + list1);

        // 11. Removing an element by index, this return the element which was removed
        list1.remove(2); // O(n)
        System.out.println("After removing an element by index from list1: " + list1);

        // 12. Removing an element by value, this returns true or false
        list1.remove("First Element"); // O(n)
        System.out.println("After removing an element by value from list1: " + list1);

        // 13. Checking the size
        int size = list1.size(); // O(1)
        System.out.println("Size of list1: " + size);

        // 14. Checking if the list is empty
        boolean isEmpty = list1.isEmpty(); // O(1)
        System.out.println("Is list1 empty? " + isEmpty);

        // 15. Clearing the list
        list1.clear(); // O(n)
        System.out.println("After clearing list1: " + list1);

        // 16. Adding multiple elements
        list1.addAll(list2); // O(n)
        System.out.println("After adding all elements from list2 to list1: " + list1);

        // 17. Checking index of an element
        int index = list1.indexOf("Banana"); // O(n)
        System.out.println("Index of 'Banana' in list1: " + index);

        // 18. Using iterator
        System.out.print("Iterating over list1: ");
        for (String fruit : list1) { // O(n)
            System.out.print(fruit + " ");
        }
        System.out.println();
    }


}
