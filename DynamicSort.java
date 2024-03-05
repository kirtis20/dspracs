package pracs;
import java.util.*;

public class DynamicSort {
    static void bubbleSort1(int[] arr1, int m) {
        int temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < (m - i); j++) {
                if (arr1[j - 1] > arr1[j]) {
                    temp = arr1[j - 1];
                    arr1[j - 1] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array and then the array elements: ");
        int m = sc.nextInt();
        int arr1[] = new int[m];

        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
            bubbleSort1(arr1, i + 1);

            System.out.println("Sorted array after " + (i + 1) + "th element is entered: ");
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[j] + " ");
            }
            System.out.println();
        }

        System.out.println("Array is sorted.");
    }
}
