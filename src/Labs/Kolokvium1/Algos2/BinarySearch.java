package Labs.Kolokvium1.Algos2;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, l, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, target);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, 0, N - 1, target);

        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("Ne postoi");
        }
    }
}
