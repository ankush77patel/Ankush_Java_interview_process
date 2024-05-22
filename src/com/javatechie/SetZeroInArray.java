package com.javatechie;

public class SetZeroInArray {
public static void main(String[] args) {
	
	//int[][] a= {{7,19,3},{4,1,0}};
	//int[][] a= {{7,19,3},{4,0,1},{4,1,1}};
	int[][] a= {{1,0},{2,7},{3,0},{4,8}};
	setZeros(a);
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<a[0].length;j++) {
			System.out.print(a[i][j] +" ");
		}
		System.out.println();
	}
	
}

public static void setZeros(int matrix[][]) {
    int row=matrix.length;
    int col=matrix[0].length;

    int count=0;
    boolean status=false;
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(matrix[i][j]==0 && !status){
            	count=j;
                j=0;
                status=true;
            }
            if(status)
            {
            	matrix[i][j]=0;
            	if(j<row)
            	matrix[j][count]=0;
            }
        }
        status=false;
        count=0;
    }
}

}
