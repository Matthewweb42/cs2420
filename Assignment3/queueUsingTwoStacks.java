import java.util.Stack;

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
       Node top;

       public Stack(){
           top = null;
       }

       public void push(int data){
           Node newNode = new Node(data);
           if(top == null){
               top = newNode;
           }else{
               newNode.next = top;
           }
       }
       public int pop(){
           int data = top.data;
           top = top.next;
           return data;
       }
    }

    private Stack stack1;
    private Stack stack2;

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();


        return 0;
    }
}
