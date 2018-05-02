import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,count,t,i;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			String s=sc.next();
			n=s.length();
			count=0;
			int a[]=new int[26];
			for(i=0;i<n;i++)
			{
				char c=s.charAt(i);
				if(a[c-97]==0)
					count++;
				a[c-97]=a[c-97]+1;
			}
			if(count%2==0)
				System.out.println("Player2");
			else
				System.out.println("Player1");
			t--;
		}
	}

}
