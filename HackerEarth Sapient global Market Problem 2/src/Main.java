import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,k,n;
		
		n=1000001;
		
		int a[]=new int [n];
		Scanner sc=new Scanner(System.in);
		
		a[1]=2;
		
		for(i=2;i<=Math.sqrt(n);i++)
		{
			if(a[i]==0)
				a[i]=1;
			for(j=2*i;j<n;j=j+i)
				a[j]=2;
		}
		n=sc.nextInt();
		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		
		for(i=0;i<n;i++)
		{
			int temp=sc.nextInt();
			if(a[temp]==1)
				l1.add(temp);
			else
				l2.add(temp);
		}
		
		Collections.sort(l1);
		Collections.sort(l2,Collections.reverseOrder());
		
		for(i=0;i<l1.size();i++)
			System.out.print(l1.get(i)+" ");
		for(i=0;i<l2.size();i++)
			System.out.print(l2.get(i)+" ");
	}

}
