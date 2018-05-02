import java.util.Scanner;

public class Main3_NSquareAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j = 0,q,i,count;
		String s;
		long sum;
		Scanner sc=new Scanner(System.in);
		
		q=sc.nextInt();
		while(q>0)
		{
			s=sc.next();	
			int n=s.length();
			int previous=-1;
			sum=0;
			count=0;
			
			int a[]=new int[26];
			for(i=0;i<n;i++)
			{
				if(previous!=-1 && count==26)
					sum=sum+previous;
				else if(previous!=-1 && count<26)
				{
					for(j=j+1;j<n;j++)
					{
						if(a[s.charAt(j)-97]==0)
							count++;
						a[s.charAt(j)-97]++;
						
						if(count==26)
						{
							sum=sum+n-j;
							previous=n-j;
							break;
						}
					}
				}
				else
				{
					count=0;
					a=new int[26];
					for(j=i;j<n;j++)
					{
						if(a[s.charAt(j)-97]==0)
							count++;
						a[s.charAt(j)-97]++;
						
						if(count==26)
						{
							sum=sum+n-j;
							previous=n-j;
							break;
						}
							
					}
					
				}
				a[s.charAt(i)-97]--;
				if(a[s.charAt(i)-97]==0)
					count--;
			}
			System.out.println(sum);

			q--;
		}
	}

}
