import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result,i,j,n,q,y,z;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		q=sc.nextInt();
		
		long a[]=new long[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextLong();
		
		HashMap<Long, HashMap<Long,Integer>> left=new HashMap<>();
		HashMap<Long, HashMap<Long,Integer>> right=new HashMap<>();
		HashMap<Long, Integer> temp=new HashMap<>();
		
		for(i=0;i<n;i++)
		{
			for(j=i;j<n;j++)
			{
				if(!left.containsKey(a[j]))
				{
					temp=new HashMap<>();
					temp.put(a[i], j-i);
					left.put(a[j], temp);
				}
				else
				{
					temp=left.get(a[j]);
					if(!temp.containsKey(a[i]))
						temp.put(a[i], j-i);
					else if(temp.get(a[i])>j-i)
						temp.put(a[i], j-i);
					left.put(a[j], temp);
				}
				
				if(!right.containsKey(a[i]))
				{
					temp=new HashMap<>();
					temp.put(a[j], j-i);
					right.put(a[i], temp);
				}
				else
				{
					temp=right.get(a[i]);
					if(!temp.containsKey(a[j]))
						temp.put(a[j], j-i);
					else if(temp.get(a[j])>j-i)
						temp.put(a[j], j-i);
					right.put(a[i], temp);
				}
			}
		}
		
		for(i=0;i<q;i++)
		{
			y=sc.nextInt();
			z=sc.nextInt();
			String d=sc.nextLine();
			
			if(d.charAt(0)=='L')
				temp=left.get(a[y]);
			else
				temp=right.get(a[y]);
			
			if(temp.containsKey(z))
				result=temp.get(z);
			else
				result=-1;
			
			System.out.println(result);
		}
	}

}
