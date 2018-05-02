import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,i,j,k;
		long sum,sum2;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		long a[]=new long[n];
		
		for(i=0;i<n;i++)
			a[i]=sc.nextLong();
		
		sum=0;
		sum2=0;
		for(i=n-1;i>0;i--)
		{
			if(a[i]>a[i-1])
				sum=sum+Math.abs(a[i]-a[i-1]);
		}
		
		for(i=0;i<n-1;i++)
		{
			if(a[i]<a[i+1])
				sum2=sum2+Math.abs(a[i]-a[i+1]);
		}
		System.out.println(Math.min(sum, sum2));
		//System.out.println(sum2);
	}

}
