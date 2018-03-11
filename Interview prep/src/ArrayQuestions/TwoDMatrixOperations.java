package ArrayQuestions;

public class TwoDMatrixOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TwoDMatrixOperations obj = TwoDMatrixOperations();
		int mat[][]= {{0,0,1},{1,0,0},{0,0,0}};
		operateTrueMatrix(mat);
	}

	static void operateTrueMatrix(int[][] mat){
		
//		int i=0,j=0;
		int r=mat.length;
		int c = mat[0].length;
		
		int row[] = new int[r];
		int column[] = new int[c];
		
		//Create all row numbers
		for (int i=0;i<r;i++) {
			row[i] = 0;
		}
		
		//Create all column numbers
		for (int j=0;j<c;j++) {
			row[j] = 0;
		}
		
		//Check all 1s in existing matrix
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if(mat[i][j]==1){
					row[i]=1;
					column[j]=1;
				}
			}
			}
		
		//modifying the matrix
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if((row[i]==1)||(column[j]==1)){
					mat[i][j]=1;
				}
			}
			}
		
		
		//Print
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				System.out.print(mat[i][j] + ",");
				}
			System.out.println("");
			}
			}
		
	}
	
