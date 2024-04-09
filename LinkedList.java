public class LinkedList {
    // Definition for a single node of the linked list.
    private static class Node {
        int item; // Each node holds an integer value.
        Node next; // Reference to the next node in the list.

        // Node constructor initializes the node with an item.
        public Node(int item) {
            this.item = item;
            this.next = null;
        }
    }

    // Removes the node that directly follows the given node in the list.
    public static void removeAfter(Node node) {
        if (node == null || node.next == null) {
            // If the node is null or there is no node after it, do nothing.
            return;
        }
        // Skip the next node, effectively removing it from the list.
        node.next = node.next.next;
    }

    // Creates and returns a deep copy of the linked list starting from the given head.
    public static Node copy(Node head) {
        if (head == null) return null; // If the list is empty, return null.

        // Create the head for the new list.
        Node newHead = new Node(head.item);
        Node currentOriginal = head; // Current node in the original list.
        Node currentNew = newHead; // Current node in the new list.

        // Iterate through the original list and copy each node.
        while (currentOriginal.next != null) {
            currentOriginal = currentOriginal.next;
            Node newNode = new Node(currentOriginal.item);
            currentNew.next = newNode;
            currentNew = newNode;
        }
        return newHead; // Return the head of the new list.
    }

    // Removes all nodes from the list that have an item equal to the given key.
    public static void removeDuplicate(Node head, int key) {
        // Special case: removing nodes from the beginning.
        while (head != null && head.item == key) {
            head = head.next;
        }

        Node current = head; // Start with the head node.

        // Iterate over the list, looking for nodes to remove.
        while (current != null && current.next != null) {
            if (current.next.item == key) {
                // If the next node should be removed, skip it.
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node.
                current = current.next;
            }
        }
    }

    // Returns the maximum item value found in the list. Returns 0 for an empty list.
    public static int max(Node head) {
        if (head == null) return 0; // Return 0 for empty list.

        int maxVal = head.item; // Assume the first item is the largest initially.
        Node current = head; // Start with the head node.

        // Iterate through the list to find the max value.
        while (current != null) {
            if (current.item > maxVal) {
                maxVal = current.item; // Update maxVal if current item is larger.
            }
            current = current.next; // Move to the next node.
        }
        return maxVal; // Return the largest value found.
    }

    // Utility method to print the linked list for demonstration.
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.item + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);

        System.out.println("After removing the node following the first node:");
        removeAfter(head);
        printList(head);

        System.out.println("Copy of the list:");
        Node copy = copy(head);
        printList(copy);

        System.out.println("Removing nodes with value '2':");
        removeDuplicate(head, 2);
        printList(head);

        System.out.println("Maximum value in the list:");
        System.out.println(max(head));
    }
}
