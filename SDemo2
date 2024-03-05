package pracs;
import java.util.LinkedList;

public class SDemo2 {
    public static void main(String[] args) {
        LinkedList node = new LinkedList<Integer>();
        node.add(11);
        node.add(100);
        node.add(30);
        node.add(40);
        node.add(50);

        LinkedList node1 = new LinkedList<Integer>();
        node1.add(10);
        node1.add(20);
        node1.add(31);
        node1.add(40);
        node1.add(50);
        node1.add(60);

        System.out.println("Modified LinkedList: " + myLinkedList(node, node1));
    }

    static LinkedList myLinkedList(LinkedList node, LinkedList node1) {
        node1.add(1, node.get(1));
        node.remove(1);
        return node1;
    }
}
