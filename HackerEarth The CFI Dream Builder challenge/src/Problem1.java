import java.util.HashMap;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t,i,j;
		long sum,count=0;
		HashMap<Long, Integer> hashMap=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			String s=sc.next();
			sum=0;
			
			for(i=0;i<s.length();i++)
			sum=sum+(s.charAt(i)-'a');
			
			if(hashMap.containsKey(sum))
				hashMap.put(sum, hashMap.get(sum)+1);
			else
				hashMap.put(sum, 1);
			
			t--;
		}
		
		count=0;
		for(Long key: hashMap.keySet())
		{
			Integer val=hashMap.get(key);
			count=count+(val*(val-1))/2;
		}
		System.out.println(count);
	}

}
