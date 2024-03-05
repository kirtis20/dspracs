package pracs;
import java.util.Scanner;

class LLNode1 {
    private int data;
    private LLNode1 next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode1 getNext() {
        return next;
    }

    public void setNext(LLNode1 next) {
        this.next = next;
    }

    public LLNode1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLDemo3 {
    static LLNode1 createLL(LLNode1 head, int data) {
        if (head == null) {
            return new LLNode1(data);
        }
        LLNode1 current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new LLNode1(data));
        return head;
    }

    static LLNode1 alterLL(LLNode1 head, int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position");
            return head;
        }
        LLNode1 newNode = new LLNode1(data);
        if (pos == 1) {
            newNode.setNext(head);
            return newNode;
        }
        LLNode1 prev = null;
        LLNode1 current = head;
        for (int i = 1; i < pos && current != null; i++) {
            prev = current;
            current = current.getNext();
        }
        if (current == null) {
            System.out.println("Position exceeds the length of the list");
            return head;
        }
        prev.setNext(newNode);
        newNode.setNext(current);
        return head;
    }

    static LLNode1 alterLL2(LLNode1 head, int d, int change) {
        LLNode1 newnode = new LLNode1(d);
        LLNode1 current = head;
        while (current != null) {
            if (current.getData() == d) {
                newnode.setNext(current.getNext());
                current.setNext(newnode);
                newnode.setData(change);
            }
            current = current.getNext();
        }
        return head;
    }

    static LLNode1 changeLL(LLNode1 head, int d, int change) {
        System.out.println("After changing:");
        LLNode1 current = head;
        while (current != null) {
            if (current.getData() == d) {
                current.setData(change);
            }
            current = current.getNext();
        }
        return head;
    }

    static LLNode1 addFirst(LLNode1 head, int d) {
        LLNode1 newNode = new LLNode1(d);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many nodes do you want?");
        int n = sc.nextInt();
        LLNode1 head = null;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data:");
            int data = sc.nextInt();
            head = createLL(head, data);
        }

        System.out.print("Original Linked List is ");
        display(head);
        System.out.println();
        System.out.println("-----alterLL-----");
        System.out.println("Enter the new data:");
        int nd = sc.nextInt();
        System.out.println("Enter the new position:");
        int np = sc.nextInt();
        head = alterLL(head, nd, np);
        display(head);
        System.out.println();
        System.out.println("-----alterLL2-----");
        System.out.println("Enter the data after which new data has to be inserted:");
        int old = sc.nextInt();
        System.out.println("Enter the new data:");
        int newd = sc.nextInt();
        head = alterLL2(head, old, newd);
        display(head);
        System.out.println();
        System.out.println("-----changeLL-----");
        System.out.println("Enter the data to be replaced:");
        int olddata = sc.nextInt();
        System.out.println("Enter the new data:");
        int replace = sc.nextInt();
        head = changeLL(head, olddata, replace);
        display(head);
        System.out.println();
        System.out.println("-----addFirst-----");
        System.out.println("Enter the data to be inserted at the start of the Linked List:");
        int startnode = sc.nextInt();
        head = addFirst(head, startnode);
        display(head);
        System.out.println("End of program");
    }

    static void display(LLNode1 head) {
        LLNode1 current = head;
        while (current != null) {
            System.out.print("-->" + current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
}
