import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListOperations {
    private Node head;

    public LinkedListOperations() {
        this.head = null;
    }

    // Insert a node at the end of the linked list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Node with data " + data + " inserted at the end");
    }

    // Insert a node at the beginning of the linked list
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Node with data " + data + " inserted at the beginning");
    }

    // Insert a node at a specific position in the linked list
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Node with data " + data + " inserted at position " + position);
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position. Node not inserted.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Node with data " + data + " inserted at position " + position);
        }
    }

    // Delete the first node from the linked list
    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            System.out.println("Node with data " + temp.data + " deleted from the beginning");
        }
    }

    // Delete the last node from the linked list
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else if (head.next == null) {
            System.out.println("Node with data " + head.data + " deleted from the end");
            head = null;
        } else {
            Node current = head;
            Node prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
            System.out.println("Node with data " + current.data + " deleted from the end");
        }
    }

    // Search for a node with specific data in the linked list
    public void searchData(int data) {
        Node current = head;
        int position = 1;
        while (current != null && current.data != data) {
            current = current.next;
            position++;
        }
        if (current != null) {
            System.out.println("Node with data " + data + " found at position " + position);
        } else {
            System.out.println("Node with data " + data + " not found in the list");
        }
    }

    // Display the linked list elements
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Reverse the linked list
    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("Linked List reversed");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperations list = new LinkedListOperations();

        int choice;
        do {
            System.out.println("\nLinked List Operations:");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Front");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete Front");
            System.out.println("5. Delete End");
            System.out.println("6. Search Data");
            System.out.println("7. Display");
            System.out.println("8. Reverse");
            System.out.println("9. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data to insert at the end:");
                    int data = sc.nextInt();
                    list.insertEnd(data);
                    break;

                case 2:
                    System.out.println("Enter data to insert at the front:");
                    int dataFront = sc.nextInt();
                    list.insertFront(dataFront);
                    break;

                case 3:
                    System.out.println("Enter data to insert:");
                    int dataPos = sc.nextInt();
                    System.out.println("Enter position to insert at:");
                    int position = sc.nextInt();
                    list.insertAtPosition(dataPos, position);
                    break;

                case 4:
                    list.deleteFront();
                    break;

                case 5:
                    list.deleteEnd();
                    break;

                case 6:
                    System.out.println("Enter data to search:");
                    int searchData = sc.nextInt();
                    list.searchData(searchData);
                    break;

                case 7:
                    System.out.println("Linked List elements:");
                    list.display();
                    break;

                case 8:
                    list.reverse();
                    break;

                case 9:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);

        sc.close();
    }
}
