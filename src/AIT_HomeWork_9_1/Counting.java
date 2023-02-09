//0 ile 5000 arasında rastgele üretilmiş 1000 adet sayıyı 
//counting sort kullanarak küçükten büyüğe sıralayınız.

package AIT_HomeWork_9_1;

import java.util.Arrays;
import java.util.Random;

public class Counting {
    static int N = 1000;
    static int[] arr = new int[N];
    
    static void countSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if((i%10 ==0) && !(i==0)){
                System.out.println("\n");
            }
        }
        System.out.println("");
    }
    
    public static void main(String args[]){
        Random random = new Random();
    
        for (int i = 0; i < N; i++)
            arr[i] = Math.abs(random.nextInt(5000));
    
        countSort(arr);
        printArray(arr);
    }
}
