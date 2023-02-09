//100.000 elemanlı bir dizinin modunu bulma
//önce diziyi sıralamadan yapıyoruz. Sonra diziyi sıralayarak
//dizinin modunu buluyoruz ve zamansal olarak diziyi karşılaştırıyoruz.

package AIT_HomeWork_8_1;

import java.util.Random;
 
public class Mode {
    static int N = 100000;
    static int[] sequence = new int[N];
 
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
  
        // pivot
        int pivot = arr[high];
  
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
  
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
  
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    
    public static int mode(){
        int maxValue = 0, maxCount = 0;
 
        for (int i = 0; i < sequence.length; ++i){
            int count = 0;
            for (int j = 0; j < sequence.length; ++j){
                if (sequence[j] == sequence[i])
                    ++count;
            }
            if (count > maxCount){
                maxCount = count;
                maxValue = sequence[i];
            }
        }
 
        return maxValue;
    }
    
    
 
    public static void main(String args[]){
        Random random = new Random();
 
        long startTime = System.currentTimeMillis(); 

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
 
        System.out.println("The set of numbers are: ");
        for (int i = 0; i < N; i++){
            System.out.print(sequence[i] + " ");
            if (i%30 == 0){
                System.out.println("\n");
            }
        }    
 
        System.out.println("\nThe mode of the set is: " + mode());
        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000; 
        System.out.println("Sırasız dizi için geçen süre: " + seconds + " saniyedir.");
        
        long startTime1 = System.currentTimeMillis();
        
        quickSort(sequence,0,99);
        
        System.out.println("\nThe mode of the set is: " + mode());
        long endTime1 = System.currentTimeMillis();
        long estimatedTime1 = endTime1 - startTime1;
        double seconds1 = (double)estimatedTime1/1000; 
        System.out.println("Sıralı dizi için geçen süre: " + seconds1 + " saniyedir.");
        
    }
}