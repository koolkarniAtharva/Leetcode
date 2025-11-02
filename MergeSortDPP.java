public class MergeSortDPP {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 3, 4, 2, 8, 0, 7, 5, 1 };
        String[] array = { "sun", "earth", "mars", "mercury" };
        int n = array.length;
        sortString(array, 0, n-1);
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(array[i] + " "); // print on same line
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy left subarray
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        // Copy right subarray
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // TODO :- Question 1 : Apply Merge sort to sort an array of Strings.(Assume
    // that all the characters in the Strings are in lowercase). (EASY)

 public static void sortString(String[] arr, int l, int r) {
    if (l < r) {
        int mid = (l + r) / 2;
        sortString(arr, l, mid);
        sortString(arr, mid + 1, r);
        mergeString(arr, l, mid, r);
    }
}

public static void mergeString(String[] arr, int l, int mid, int r) {
    int n1 = mid - l + 1;
    int n2 = r - mid;

    String[] L = new String[n1];
    String[] R = new String[n2];

    // Copy left half
    for (int i = 0; i < n1; i++) {
        L[i] = arr[l + i];
    }

    // Copy right half
    for (int j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0, k = l;

    // Merge two halves
    while (i < n1 && j < n2) {
        if (L[i].compareTo(R[j]) <= 0) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy leftover elements
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

}
