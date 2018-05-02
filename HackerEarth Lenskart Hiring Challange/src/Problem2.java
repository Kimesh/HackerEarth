import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t,n,i,j,k;
		long max=-1;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			n=sc.nextInt();
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			max=-1;
			for(i=0;i<n-1;i++)
			{
				if(Math.abs(a[i+1]-a[i])>max)
					max=(long)Math.abs(a[i+1]-a[i]);
			}
			System.out.println(max);
			t--;
		}
	}

}
