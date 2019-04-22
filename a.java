import java.io.*;
import java.util.*;
public class a {
   public static void main(String args[] ) throws Exception {

	//Write code here
   Scanner sc = new Scanner(System.in);
   int t = sc.nextInt();
   while(t--!=0) {
      int n = sc.nextInt();
     int a[] = new int[n];
     for(int i=0;i<n;i++) 
     a[i] = sc.nextInt();
     int prev_inc = a[0];
     int prev_exc = 0;
  Stack<Integer> includeStack = new Stack<Integer>();
  includeStack.push(a[0]);
  Stack<Integer> excludeStack = new Stack<Integer>();
     for(int i=1;i<n;i++) {
        int include = prev_exc+a[i];
        int exclude = Math.max(prev_exc,prev_inc);
        Stack<Integer> copiedStack = new Stack<Integer>();
        copiedStack.addAll(excludeStack);
        if(prev_inc>prev_exc) {
           excludeStack.clear();
      excludeStack.addAll(includeStack);
        }
      includeStack.clear();
      includeStack.addAll(copiedStack);
        includeStack.push(a[i]);
        prev_inc = include;
        prev_exc= exclude;
     }
    if(prev_inc>prev_exc) {
       while(!includeStack.isEmpty())
       System.out.print(includeStack.pop());
    }
    else if(prev_exc>prev_inc) {
       while(!excludeStack.isEmpty())
       System.out.print(excludeStack.pop());
    }
    else {
       if(excludeStack.peek()>includeStack.peek()) {
         while(!excludeStack.isEmpty())
         System.out.print(excludeStack.pop());
       }
       else {
         while(!includeStack.isEmpty())
         System.out.print(includeStack.pop());
       }
    }
    System.out.println("");
   }
}
}

