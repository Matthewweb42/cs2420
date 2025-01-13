import java.util.Scanner;
import java.util.Random();



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
        
            int [][] randomMatrix = new int[dimensions][dimensions];

        }
   
    }

    
    

}