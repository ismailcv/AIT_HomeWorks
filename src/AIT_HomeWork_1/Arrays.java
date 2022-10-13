package AIT_HomeWork_1;

public class Arrays {
    
    //Sıralı dizi tanımlama işlemi
    public static int[] sortedArray(){
        int[] arrSorted = new int[100000];
        
        for (int i =0; i<100000;i++){
            arrSorted[i] = i;
        }
        return arrSorted;
    }
    
    //Tersine sıralı dizi tanımlama işlemi
    public static int[] reverseSorted(){
        int[] arrReverseSorted = new int[100000];
        for (int j=0; j<100000; j++){
            arrReverseSorted[j] = 999999 - j;
        }
        return arrReverseSorted;
    }
    
    //Rastgele dizi tanımlama işlemi
    public static int[] randomSorted(){
        int[] arrRandomSorted = new int[100000];
        for(int x =0; x<100000;x++){
            arrRandomSorted[x]= (int) Math.floor(
                    Math.random()*(100-1+5)+1);
        }
        return arrRandomSorted;
    }    
}
