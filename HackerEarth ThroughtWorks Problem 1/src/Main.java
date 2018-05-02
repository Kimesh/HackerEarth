import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t,i,k,n,j;
		long count;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			k=sc.nextInt();
			n=sc.nextInt();
			int a[]=new int[n];
			count=0;
			for(i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
				
				if(a[i]<k)
					count=count+(k-a[i]);
				else if(a[i]%k==0)
					continue;
				else if(a[i]>k)
				{
					int mod=a[i]%k;
					int div=a[i]/k;
					div++;
					long l=k*div-a[i];
					count=(int) (count+Math.min(l, mod));
				}
			}
			
			System.out.println(count);
			t--;
		}
	}

}
