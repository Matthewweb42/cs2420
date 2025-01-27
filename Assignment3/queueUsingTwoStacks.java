import java.util.Scanner;


public class queueUsingTwoStacks {

   private static class Node{// create the array for the first stack.
       int data;
       Node next;

       public Node(int data){// set up the stack function.
           this.data = data;
           this.next = null;

       }
   }
    private static class Stack{
       private Node top;

       public Stack(){
           top = null;
       }

       public void push(int data){
           Node newNode = new Node(data);
           if(top == null){
               top = newNode;
           }else{
               newNode.next = top;
               top = newNode;
           }
       }
       public int pop(){
           int data = top.data;
           top = top.next;
           return data;
       }
       public boolean isEmpty(){
           return top == null;
       }

       public void printStacks(String stack){
            Node current = top;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
           System.out.println();
        }
    }


    private Stack stack1;
    private Stack stack2;
    public queueUsingTwoStacks(){
        stack1 = new Stack();
        stack2 = new Stack();
    }


    public void enqueue(int value) {
        stack1.push(value);

    }

    public int dequeue() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public void printStacks() {
        stack1.printStacks("Stack1");
        stack2.printStacks("Stack2");
    }



    public static void main(String[] args) {
        queueUsingTwoStacks queue = new queueUsingTwoStacks();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Press 1 for enqueue. Press 2 for dequeue. Press 0 to exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Please input the number you would like to Enqueue: ");
                int data = scanner.nextInt();
                queue.enqueue(data);
                queue.printStacks();
            }else if(choice == 2){
                queue.dequeue();
                queue.printStacks();
            }else if(choice == 0){
                System.out.println("Exiting...");
                exit = true;
            }
        }

    }
}
