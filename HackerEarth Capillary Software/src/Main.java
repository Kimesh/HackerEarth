import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,n;
		long t,k,q;
		long partition,localMax,globalMin=Integer.MAX_VALUE;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			q=sc.nextInt();
			
			long a[]=new long[n];
			
			for(i=0;i<n;i++)
				a[i]=sc.nextLong();
			localMax=Long.MIN_VALUE;
			globalMin=Long.MAX_VALUE;
			partition=n/k;
			for(j=1,i=0;j<=k;j++)
			{
				localMax=0;
				while(i<j*partition && i<n)
				{
					if(a[i]>localMax)
						localMax=a[i];
					i++;
				}
				if(localMax<globalMin)
					globalMin=localMax;
			}
			if(globalMin<q)
				System.out.println(globalMin);
			else
			System.out.println(" NO ");
			t--;
		}
	}

}
