//Algoritma analizi 1. ödev

package AIT_HomeWork_1;

import java.util.Random;
import java.util.Scanner;

//Burada şunu yapacağız 3 tane arama ve 3 tane sıralama algoritmasını zamansal olarak
//karşılaştırmasını yapıcaz best, worst ve avarage durum olarak.
// Yaptığımız bu karşılaştırmaların sonucu excel dosyasına not edeceğiz.

public class Main { 
    public static void main(String[] args) {
              
        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();
        InterpolationSearch interpolationsearch = new InterpolationSearch();
         
        System.out.println("Sıralı dizide seleciton sort için 1 \n"
                + "Tersine sıralı dizide seleciton sort için 2 \n"
                + "Rastgele sıralı dizide seleciton sort için 3 \n"
                + "Sıralı dizide bubble sort için 4 \n"
                + "Tersine sıralı dizide bubble sort için 5 \n"
                + "Rastgele sıralı dizide bubble sort için 6 \n"
                + "Sıralı dizide insertion sort için 7 \n"
                + "Tersine sıralı dizide insertion sort için 8 \n"
                + "Rastgele sıralı dizide insertion sort için 9 \n"
                + "Sıralı dizide linear search için 11 \n"
                + "Tersine sıralı dizide linear search için 12 \n"
                + "Rastgele sıralı dizide linear search için 13 \n"
                + "Sıralı dizide binary search için 14 \n"
                + "Tersine sıralı dizide binary search için 15 \n"
                + "Rastgele sıralı dizide binary search için 16 \n"
                + "Sıralı dizide interpoaliton search için 17 \n"
                + "Tersine sıralı dizide interpolaiton search için 18 \n"
                + "Rastgele sıralı dizide interpolation search için 19 \n");
        
        System.out.println("\nHangi işlemi seçeceksiniz: ");
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
         //Zamanlayıcıyı burada başlatıyoruz.
        long startTime = System.nanoTime();
        
        if(choice == 1){
            selectionSort.selectionSorting(Arrays.sortedArray());
        }else if(choice == 2){
            selectionSort.selectionSorting(Arrays.reverseSorted());
        }else if(choice == 3){
            selectionSort.selectionSorting(Arrays.randomSorted());
        }else if(choice == 4){
            bubbleSort.bubbleSorting(Arrays.sortedArray());
        }else if(choice == 5){
            bubbleSort.bubbleSorting(Arrays.reverseSorted());
        }else if(choice == 6){
            bubbleSort.bubbleSorting(Arrays.randomSorted());
        }else if(choice == 7){
            insertionSort.insertionSorting(Arrays.sortedArray());
        }else if(choice == 8){
            insertionSort.insertionSorting(Arrays.reverseSorted());
        }else if(choice == 9){
            insertionSort.insertionSorting(Arrays.randomSorted());
        }else if(choice == 11){
            LinearSearch.linearSearching(Arrays.sortedArray(), 99999);
        }else if(choice == 12){
            LinearSearch.linearSearching(Arrays.reverseSorted(), 99999);
        }else if(choice == 13){
            linearSearch.linearSearching(Arrays.randomSorted(), 99999);
        }else if(choice == 14){
            //1 değeri en küçük değer 99.999 dizi boyutu 80.000 aranan değer
            binarySearch.binarySearching(Arrays.sortedArray(), 1, 99999, 80000);
        }else if(choice == 15){
           binarySearch.binarySearching(Arrays.reverseSorted(), 1, 99999, 80000); 
        }else if(choice == 16){
            binarySearch.binarySearching(Arrays.randomSorted(), 1, 99999, 80000);
        }else if(choice == 17){
            //50000 değeri aranan değer, 1 değeri en küçük, 99999 en büyük
            interpolationsearch.interpolationSearching(Arrays.sortedArray(), 1, 99999, 50000);
        }else if(choice == 18){
            interpolationsearch.interpolationSearching(Arrays.reverseSorted(), 1, 99999, 50000);
        }else if(choice == 19){
            interpolationsearch.interpolationSearching(Arrays.randomSorted(), 1, 99999, 50000);
        }else{
            System.out.println("Yanlış girdi verd");
        }
              
        //burada sonlandırıyoruz.
        long endTime = System.nanoTime();
        
        //Burada geçen zamanı alıyoruz.
        long estimatedTime = endTime - startTime;
        
        //Nano saniyeyi saniyeye çeviriyoruz.
        double seconds = (double)estimatedTime/1000000000;
        
        //Saniye cinsinden yazdırıyoruz.
        System.out.println("Time: " + (float) seconds);
    }   
}
