import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,t,i;
		
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[n];
		Stack<Integer> s=new Stack<Integer>();
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		s.push(n-1);
		for(i=n-2;i>=0;i--)
		{
			while(!s.isEmpty())
			{
				int val=s.peek();
				if(a[i]>a[val])
					s.pop();
				else
				{
					s.push(i);
					break;
				}
			}
			if(s.isEmpty())
				s.push(i);
		}
		while(!s.isEmpty())
			System.out.print(""+(s.pop().intValue()+1)+" ");
	}

}
