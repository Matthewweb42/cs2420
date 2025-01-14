import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class matrix{
    public static void main(String[] args) {
        
    
        int dimensions;
        boolean goodNum = false;
        boolean finished = false; 
        while (!finished){
            Scanner scanner = new Scanner(System.in); //create scanner
        
            while (!goodNum){ //check to make sure number is valid
                System.out.println("Please enter the dimensions of the square matrix from 0 to 50");

                dimensions = scanner.nextInt();
            
                if (dimensions <0 || dimensions > 50){
                    System.out.println("Invalid input. Please enter a number between 0 and 50");
                }
                else{
                    goodNum = true;
                
                
                //print text and call important functions
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

                Instant startTime = Instant.now();
                printMatrix((multiplyMatrix(rndMatrix1,rndMatrix2)));
                Instant endTime = Instant.now();
                
                System.out.println();
                System.out.println();
                Duration duration = Duration.between(startTime, endTime);
                System.out.println("Total execution time: " + duration.toMillis()+"ms");
                System.out.println();
           

                System.out.println("Would you like to continue? y/n");
                String repeat = scanner.next();
                if (repeat.equals("y")){ //continue check
 
                    finished = false;
                    goodNum = false;
                }else{
                    finished = true;
                }
                } 
            }
        }
    }
    
    public static int[][] randomMatrixGenerator(int dimensions){ //simple random number generator. 
        int [][] randomMatrix1 = new int[dimensions][dimensions];
        Random random = new Random();
        for (int i=0; i < dimensions; i++){
            for (int j=0; j<dimensions;j++){
                randomMatrix1[i][j] = random.nextInt(50);
            }
        }
        return randomMatrix1;
    }

    public static int[][] multiplyMatrix(int [][] matrix1, int [][] matrix2){
        int[][] lastMatrix= new int[matrix1.length][matrix2.length];
        for (int i = 0; i<matrix1.length; i++){ //row iteration
            for (int j = 0; j<matrix1.length; j++){ //column iteration
                for (int k = 0; k<matrix1.length; k++){ // digit iteration
                    lastMatrix[i][j] += matrix1[i][k]*matrix2[k][j]; //calculation
                }
            }
        }
        return lastMatrix;
    }

    public static void printMatrix(int [][]matrix){ //formating and printing
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

