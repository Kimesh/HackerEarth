import java.util.HashMap;
import java.util.Scanner;

public class OddEvenSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n,i,j;
		long count=0,sum=0;
		HashMap<Long,Long> hashMap=new HashMap<Long,Long>(); 
		Scanner sc=new Scanner(System.in);
		if(sc.hasNextLine())
		{
			n=sc.nextInt();
			long a[]=new long[n];
			for(i=0;i<n;i++)
			{
				a[i]=sc.nextLong();
				a[i]=(((a[i]%2)+2)%2)==0?-1:1;
			}
			sc.close();	
			for(i=0;i<n;i++)
			{
				sum=sum+a[i];
				if(hashMap.containsKey(sum))
					hashMap.put(sum, hashMap.get(sum)+1);
				else
					hashMap.put(sum,(long) 1);
			}
			
			for(Long val:hashMap.values())
				count=count+((val-1)*val)/2;
			Long val=hashMap.get((long) 0);
			if(val!=null)
			count=count+val;
		}
		System.out.println(count);
	}

}
