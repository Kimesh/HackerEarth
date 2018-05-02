import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,k,n;
		
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int [n];
		int b[]=new int [n];
		int c[]=new int [n];
		
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		
		Stack<Integer> stack=new Stack<Integer>();
		
		stack.push(0);
		
		for(i=1;i<n;i++)
		{
			while(!stack.isEmpty() && a[stack.peek()]<a[i])
				b[stack.pop()]=i;
			stack.push(i);
		}
		while(!stack.isEmpty())
			b[stack.pop()]=-1;
		
		stack.push(0);
		
		for(i=1;i<n;i++)
		{
			while(!stack.isEmpty() && a[stack.peek()]>a[i])
				c[stack.pop()]=i;
			stack.push(i);
		}
		while(!stack.isEmpty())
			c[stack.pop()]=-1;
		
		for(i=0;i<n;i++)
		{			
			if(b[i]!=-1 && c[b[i]]!=-1)
				System.out.print(a[c[b[i]]]+" ");
			else
				System.out.print(-1+" ");
		}
		
		}

}
