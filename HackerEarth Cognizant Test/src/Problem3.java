import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,t,n;
		long sum;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			sum=0;
			n=sc.nextInt();
			int a[]=new int[n];
//			for(i=0;i<n;i++)
//				a[i]=sc.nextInt();
			
			TreeSet<Integer> set=new TreeSet<>();
			for(i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
				Integer floor=set.floor(a[i]);
				if(floor==null)
					sum=sum-1;
				else
					sum=sum+floor;
				
				set.add(a[i]);
			}
				System.out.println(sum);
			
			t--;
		}
	}

}
