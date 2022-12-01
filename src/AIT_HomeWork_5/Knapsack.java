//Knapsack Problem n adet eşya vardır. Her bir eşyanın ağırlığı ve değeri 
//mevcuttur. Çantanın taşıyabileceği max. ağırlık değeri mevcuttur. 
//Aşağıdaki tabloya göre çantaya hangi eşyaların
//koyulması daha karlı olacaktır? Kaba kuvvet yöntemiyle çözümü bulan 
//programı derleyiniz.

package AIT_HomeWork_5;

public class Knapsack {
    public static void knapsackDyProg(int W[], int V[], int M, int n) {
	int B[][] = new int[n + 1][M + 1];
	
	for (int i=0; i<=n; i++)
		for (int j=0; j<=M; j++) {
			B[i][j] = 0;
		}
	
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= M; j++) {
			B[i][j] = B[i - 1][j];
			
			if ((j >= W[i-1]) && (B[i][j] < B[i - 1][j - W[i - 1]]
                                + V[i - 1])) {
				B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1]; 
			}
			
			System.out.print(B[i][j] + " ");
		}
		System.out.print("\n");
	}
	
	System.out.println("Max Value:\t" + B[n][M]);
	System.out.println("Selected Packs: ");
	
	while (n != 0) {
		if (B[n][M] != B[n - 1][M]) {
			System.out.println("\tPackage " + n + " with W = " 
                                + W[n - 1] + " and Value = " + V[n - 1]);
			
			M = M - W[n-1];
		}
		n--;
	}
    }
      
    public static void main(String[] args) {  
        //W dediğimiz değer ağırlıkları ifade eder.
	int W[] = new int[]{2, 5, 10, 5, 3,1,3,4,5,7};
	
        //V dediğimiz değişken paketin değerini ifade eder.
	int V[] = new int[]{20, 30, 60, 10, 40,10,30,40,80,70};

	//M dediğimiz değer maksimum ağırlığı ifade eder.
	int M = 16;
	int n = V.length;
	
	knapsackDyProg(W, V, M, n);
    }
}
