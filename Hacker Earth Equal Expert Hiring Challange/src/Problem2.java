import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Problem2 {

	static HashMap<Long, HashSet<Long>> map;
	static HashSet<Long> hashSet=new HashSet<>();
	static int globalDepth=Integer.MAX_VALUE;
	static boolean flag;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,x,m,n,u,v,q;
		long key,value,k;
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		q=sc.nextInt();
		long a[]=new long[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextLong();
		map=new HashMap<>();
		for(i=0;i<n-1;i++)
		{
			u=sc.nextInt();
			v=sc.nextInt();
			key=a[u-1];
			value=a[v-1];
			if(!map.containsKey(key))
			{
				HashSet<Long> temp=new HashSet<>();
				temp.add(value);
				map.put(key, temp);
			}
			else
			{
				HashSet<Long> temp=map.get(key);
				temp.add(value);
				map.put(key, temp);
			}
			if(!map.containsKey(value))
			{
				HashSet<Long> temp=new HashSet<>();
				temp.add(key);
				map.put(value, temp);
			}
			else
			{
				HashSet<Long> temp=map.get(value);
				temp.add(key);
				map.put(key, temp);
			}	
		}
		
		for(i=0;i<q;i++)
		{
			x=sc.nextInt();
			k=sc.nextLong();
			int depth=BFS(a[x-1],(long) 0,0,k);
			if(flag)
			System.out.println(depth);
			else
				System.out.println("-1");
		}
	}
	private static int BFS(Long node, Long sum, int count, long k) {
		if(sum+node>=k)
		{
			flag=true;
			return count+1;
		}
			
		if(!hashSet.contains(node))
			hashSet.add(node);
		HashSet<Long> temp=map.get(node);
		if(temp==null)
			return globalDepth;
		for(Long itr: temp)
		{
			if(!hashSet.contains(itr))
			{
				int localDepth=BFS(itr,sum+node,count+1,k);
				if(localDepth<globalDepth)
					globalDepth=localDepth;
			}
		}
		return globalDepth;
	}
}
