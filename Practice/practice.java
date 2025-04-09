public class practice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    //Big O is O(n): The runtime grows linearly with the size of the input
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    //Big O is O(n): Program goes to every Node once, so it's only N
    int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.value + sum(node.left) + sum(node.right);
    }
    //Big O is O(sqrt(n)): The X goes up by X^2, or rather X^2 = N, which means x = sqrt(N)
    boolean isPrime(int n){
        for (int x= 2; x*x <= n; x++){
            if (n % x == 0){
                return false;
            }
        }
        return true;
    }
    //Big O is O(n). Calls itself n times
    int factorial(int n){
        if (n<0){
            return -1;
        }else if (n == 0){
            return 1;
    }  else {
            return n * factorial(n-1);
        }
    }
    //Big O is O(2^n): Calls the recursion function twice. 
    int fib(int n){
        if (n<=0) return 0;
        else if (n == 1) return 1;
        else return fib(n-1) + fib(n-2);
    }

    //Big O is O(2^n): Same thing, calls the fib which is called twice within fib. 
    void allFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i));
        }
    }

    //Big O is O(log n): Each time the power is called recursively, it's divided by 2.
    int powersOf2(int n) {
        if (n<1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n/2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    //Big O is O(1): No recursion or loops or anything, strictly constant time.
    int mod(int a, int b){
        if (b <= 0){
            return -1;
        }
        int div = a/b;
        return a - div * b;
    }

    //Big O is O(logn): Each time the sum is calculated, it's divided by a number, which results in a log function.
    int sumDigits(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //Big O is O(A*B): The runtime is proportional to the product of the sizes of A and B.
    void printUnorderedPairs(int[] arrayA, int[] arrayB){
        for (int i = 0; i < arrayA.length; i++){
            for (int j = 0; j < arrayB.length; j++){
                for (int k = 0; k < 100000; k++){
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }
}