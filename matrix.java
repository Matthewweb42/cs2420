import java.util.Scanner;


import java.util.Random;



public class Matrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //create scanner
        System.out.println("Please enter the dimensions of the first square matrix from 0 to 50");
        
        int dimensions;
        
        boolean goodNum = false;

        while (!goodNum){
            dimensions = scanner.nextInt();
           
            if (dimensions <0 || dimensions > 50){
                System.out.println("Invalid input. Please enter a number between 0 and 50");
            }
            else{
                goodNum = true;
            }
            System.out.println("Matrix 1 is as follows:");
            int [][] rndMatrix1 = randomMatrixGenerator(dimensions);
            printMatrix(rndMatrix1);
            System.out.println();

            System.out.println();
            System.out.println("Matrix 2 is as follows:");
            int [][] rndMatrix2 = randomMatrixGenerator(dimensions);
            printMatrix(rndMatrix2);

            System.out.println();
            System.out.println();

            System.out.println("Result Matrix is as follows:");
            printMatrix((multiplyMatrix(rndMatrix1,rndMatrix2)));
            
        }


        
    }
    
    public static int[][] randomMatrixGenerator(int dimensions){
        int [][] randomMatrix1 = new int[dimensions][dimensions];
        Random random = new Random();
        for (int i=0; i < dimensions; i++){
            for (int j=0; j<dimensions;j++){
                randomMatrix1[i][j] = random.nextInt(4);
            }
        }
        return randomMatrix1;
    }

    public static int [][] multiplyMatrix(int [][] matrix1, int [][] matrix2){
        int[][] lastMatrix= new int[matrix1.length][matrix2.length];
        for (int i = 0; i<matrix1.length; i++){
            for (int j = 0; j<matrix1.length-1; j++){
                lastMatrix[i][j]= matrix1[i][j]*matrix2[i][j];
            }
        }
        return lastMatrix;
    }

    public static void printMatrix(int [][]matrix){
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++){
            System.out.print("[");
            for (int j = 0; j < matrix.length; j++){
                if (j == matrix.length-1){
                    System.out.print(matrix[i][j]); 
                }else{
                    System.out.print(matrix[i][j]+", ");
                }
            }
            if (i == matrix.length-1){
                System.out.print("]");

            }else{
                System.out.println("],");
            }
        }
        System.out.print("]");

    }
}  

