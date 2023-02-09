//İçerisinde 1’den 100’e kadar rastgele değerler olan bir diziyi 
// Merge Sort algoritması ile küçükten büyüğe, büyükten küçüğe sıralayınız.

package AIT_HomeWork_7_2;

import java.util.Arrays;
import java.util.Random;

public class RecursiveMergeSort {
    public static void mergeSort(int[] a, int n) {
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
    merge(a, l, r, mid, n - mid);
}
    public static void merge(
    int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
    static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
  
        // printing the reversed array
        System.out.println("Reversed array is: \n");
        for (k = 0; k < n; k++) {
            System.out.print(a[k]+ ", ");
        }
    }
   
    
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[100];
        
        for(int i=0;i<100;i++){
            arr[i]=rand.nextInt(100);
        }
            
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, arr.length);
        System.out.println("----------------------\n"+Arrays.toString(arr));
        reverse(arr, 100);
         
    }

}