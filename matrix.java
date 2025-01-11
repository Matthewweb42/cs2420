import java.util.Scanner;



public class Matrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //create scanner
        System.out.println("Please enter the dimensions of the first square matrix from 0 to 50");
        
        int dimensions1;
        int dimensions2;
        boolean goodNum = false;

        while (!goodNum){
            dimensions1 = scanner.nextInt();
            dimensions2 = scanner.nextInt();
            if (dimensions1 <0 || dimensions1 > 50){
                System.out.println("Invalid input. Please enter a number between 0 and 50");
            }else if(dimensions2 <0 || dimensions2 >50){
                System.out.println("Invalid input. Please enter a number between 0 and 50");
            }
            else{
                goodNum = true;

            }
        
        }
   
    }

    
    

}