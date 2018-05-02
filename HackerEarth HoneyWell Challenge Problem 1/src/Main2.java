import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j,q,i,count;
		String s;
		long sum;
		Scanner sc=new Scanner(System.in);
		
		q=sc.nextInt();
		while(q>0)
		{
			s=sc.next();	
			int a[]=new int[26];
			
			i=0;
			j=0;
			sum=0;
			count=0;
			
			while(i<s.length())
			{
				if(a[s.charAt(i)-97]==0)
					count++;
				a[s.charAt(i)-97]++;
				
				while(count==26)
				{
					sum++;
					a[s.charAt(j)-97]--;
					if(a[s.charAt(j)-97]==0)
						count--;
					j++;
				}
				i++;
			}
			System.out.println(sum);

			q--;
		}
	}

}
