//Aşağıda komşuluk matrisi verilen graphların yönlü olup 
//olmadığını bulan programı yazınız.

package AIT_Homework_6_1;

class SymmetricFounder {
	
static int MAX = 100;

// Fills transpose of mat[N][N] in tr[N][N]
static void transpose(int mat[][], int tr[][], int N)
{
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			tr[i][j] = mat[j][i];
}

// Returns true if mat[N][N] is symmetric, else false
static boolean isSymmetric(int mat[][], int N)
{
	int tr[][] = new int[N][MAX];
	transpose(mat, tr, N);
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			if (mat[i][j] != tr[i][j])
				return false;
	return true;
}

// Driver code
	public static void main (String[] args)
{
		
		int matrix1[][] = { 
                    { 0, 0, 0, 0, 1},
		    { 1, 0, 0, 0, 1},
		    { 0, 1, 0, 0, 0},
                    { 0, 1, 0, 0, 1},
                    { 0, 0, 1, 1, 0}
                    };
                
                int matrix2[][] = { 
                    { 0, 1, 1, 0, 0},
		    { 1, 0, 0, 1, 1},
		    { 1, 0, 0, 0, 0},
                    { 0, 1, 0, 0, 1},
                    { 0, 1, 0, 1, 0}
                    };
                

	if (isSymmetric(matrix1, 3)){
            System.out.println( "Bu matrix yönlü bir matrix'tir.");
        }else{
		System.out.println ( "Bu matrix yönsüz bir matrix'tir.");
	}
        
        if (isSymmetric(matrix2, 3)){
            System.out.println( "Bu matrix yönlü bir matrix'tir.");
        }else{
		System.out.println ( "Bu matrix yönsüz bir matrix'tir.");
	}
            
        
    }     
}

