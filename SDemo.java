package pracs;
import java.util.LinkedList;
import java.util.Iterator;

public class SDemo {
    public static void main(String[] args) {
        LinkedList node = new LinkedList<Integer>();
        node.add(11);
        node.add(20);
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

        System.out.println("Sum of elements from both lists: " + addList(node, node1));
        System.out.println("Sum of odd numbers from both lists: " + addOddNumbers(node, node1));
    }

    static int addList(LinkedList node, LinkedList node1) {
        node.addAll(node1);
        int size = node.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += (int) node.get(i);
        }
        return sum;
    }

    static int addOddNumbers(LinkedList node, LinkedList node1) {
        node.addAll(node1);
        int sumOfOddNumbers = 0;

        Iterator it = node.iterator();
        while (it.hasNext()) {
            int n = (Integer) it.next();
            if (n % 2 != 0) {
                sumOfOddNumbers += n;
            }
        }
        return sumOfOddNumbers;
    }
}
