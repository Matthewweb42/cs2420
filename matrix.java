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
        

        }


        
    }

    public static int[][] randomMatrixGenerator(int dimensions,int dimensions){
        int [][] randomMatrix1 = new int[dimensions][dimensions];
        int [][] randomMatrix2 = new int[dimensions][dimensions];
        Random random = new Random();
        for (int i=0; i < dimensions; i++){
            for (int j=0; j<dimensions;j++){
                randomMatrix1[i][j] = random.nextInt(dimensions);
                randomMatrix2[i][j] = random.nextInt(dimensions);
            }
        }
        
    }

    
}  

