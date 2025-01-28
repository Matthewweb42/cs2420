import java.util.Scanner;

public class directAccessSearch {
    public static void main(String[] args) {
        int[] A = {-2, -5, -3 , 4, -4, 2, 5}; //sample array
        int MAX = 5; //max, is subject to change depending on sample array
        int[][] hashMap = new int[MAX+1][2]; //initilize hashMap and assign
        for (int value : A) {
            if (value >0){
                hashMap[value][0] = 1;
            }else{
                hashMap[Math.abs(value)][1] = 1;
            }
        }
        boolean validInput = false; //check for valid input and call search
        Scanner scanner = new Scanner(System.in);
        while (validInput == false) {
            System.out.println("Enter search term: ");
            int searchTerm = scanner.nextInt();
            if (searchTerm > MAX){
                System.out.println("Invalid search term, try again");
                validInput = false;
            }else{
                boolean key = search(hashMap,searchTerm);
                System.out.println("Search (A, " + searchTerm + ") = " + key);
                validInput = true;
            }
        }

    }

    public static boolean search(int[][] hashMap, int key) { //search for key
        if (key > 0){
            return hashMap[key][0] == 1;
        }else{
            return hashMap[Math.abs(key)][1] == 1;
        }
    }

}
