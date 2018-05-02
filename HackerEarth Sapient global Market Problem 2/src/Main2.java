import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		int i,n,k,j;
		boolean flag;
		n=sc.nextInt();
		int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		
		for(i=0;i<n;i++)
		{
			flag=true;
			if(a[i]==1)
			{
				l2.add(a[i]);
				continue;
			}
				
			for(j=2;j<=Math.sqrt(a[i]);j++)
			{
				if(a[i]%j==0)
				{
					flag=false;
					l2.add(a[i]);
					break;
				}
			}
			if(flag)
				l1.add(a[i]);
		}
		
		Collections.sort(l1);
		Collections.sort(l2,Collections.reverseOrder());
		
		for(i=0;i<l1.size();i++)
			System.out.print(l1.get(i)+" ");
		for(i=0;i<l2.size();i++)
			System.out.print(l2.get(i)+" ");
	}
}
