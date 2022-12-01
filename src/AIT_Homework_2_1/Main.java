//Birbirine eşit uzaklıktaki köylerden her köye eşit uzaklıktaki köyü bulan algoritma

package AIT_Homework_2_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[99]; 
        int distance;
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Köyler arası uzaklığı giriniz: ");
        distance = scanner.nextInt();
             
        for (int i=0; i<arr.length;i++){
          arr[i] = (distance) + 5;   
        }
       
        if(arr.length%2 == 1){
            System.out.println("Tüm köylerin ortasında ki köy: " + ((arr.length/2)+1) +". köy");
            System.out.println("En yakın köylere uzaklığı: " + distance + " birim olur.");
        }else {
            System.out.println("Tüm köylerin ortasında ki köy ya: " + (arr.length/2) +
                    "ya da " + ((arr.length/2)-1) + ". köy olur." );
        }
        
        System.out.println("Kaçıncı köyü aramak istiyorsunuz?");
        int village = scanner.nextInt();
        
        if(village > arr.length/2){
            System.out.println("Bu köye en uzak köy 1. köy olur");
        }else if(village < arr.length/2){
            System.out.println("Bu köye en uzak köy 99. köy olur");
        }
        
        
       
     
    }
}
