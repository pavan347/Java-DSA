package org.matrixprograms;

public class MatrixPrograms {

    public void printmatrix(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for( int j = 0 ; j < matrix.length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void multiplyTwoMatrics(int[][] matrix1, int[][] matrix2){

        if(matrix1[0].length != matrix2.length) {
            System.out.println("The matrix length dosen't support for multiplication");
            return;
        }

        int[][] resultantMatrix = new int[matrix1.length][matrix2[0].length];

        for(int i = 0 ; i < matrix1.length ; i++) {
            for( int j = 0 ; j < matrix2[0].length ; j++) {
                resultantMatrix[i][j] = 0;
                for(int k = 0; k < matrix1[0].length; k++) {
                    resultantMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        printmatrix(resultantMatrix);
    }

    public void findSumOfEachRowandColumn(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            int rowSum = 0;
            int colSum = 0;
            for( int j = 0 ; j < matrix[0].length ; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            System.out.println(i + "st Row Sum:" + rowSum);
            System.out.println(i + "st Row Sum:" + colSum);
        }
    }

    public static void main(String[] args) {
        int a[][]={{1,1,1},{2,2,2},{3,3,3}};
        int b[][]={{1,1,1},{2,2,2},{3,3,3}};
        MatrixPrograms mp = new MatrixPrograms();
//        mp.multiplyTwoMatrics(a, b);
        mp.findSumOfEachRowandColumn(a);
    }
}
