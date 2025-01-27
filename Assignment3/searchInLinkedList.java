
import java.util.Scanner;
import java.util.Random;

public class searchInLinkedList {
//creating the list
    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < 10; i++) {
            int value = new Random().nextInt(100); //Initialize the Linked list with random numbers
            Node newNode = new Node(value);
            if (head == null) { //setting head and tail to correct values
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

            }
        }

        //printing the linked list Left to Right
        Node current = head;
        System.out.print("Linked list values Left to Right: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;

        }
        //printing right to left
        current = tail;
        System.out.println();
        System.out.print("Linked list values Right to Left: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        //Search Key input
        System.out.println();
        System.out.print("Please input a Search Key 0-100: ");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int key = sc.nextInt();

        //Search for key
        boolean found = false;
        current = head;
        while(current != null) {
            if(key == current.data) {
                found = true;
                break;
            }
            current = current.next;
        }

        //print results
        if (found){
            System.out.println("The Key is in the List!");
        }else{
            System.out.println("Key does not exist!");
        }

    }



}
