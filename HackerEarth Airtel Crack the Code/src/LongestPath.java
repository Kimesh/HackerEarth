import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LongestPath {

	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
            
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                	String str=br.readLine();
                	if(str!=null)
                		st=new StringTokenizer(str);
                	else
                		st=new StringTokenizer("");
                  //  st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
        
	public static void main(String[]args)
	{
		int u,v,i,n,j,k,newKey = 0;
		long max;
		HashMap<Integer, HashSet<Integer>> hashMap=new HashMap<>();
		FastReader sc=new FastReader();
		n=sc.nextInt();
		k=sc.nextInt();
		
		int a[]=new int [n];
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		for(i=0;i<n-1;i++)
		{
			u=sc.nextInt();
			v=sc.nextInt();
			if(u!=v)
			{
				if(hashMap.containsKey(u))
				{
					HashSet temp=hashMap.get(u);
					temp.add(v);
					hashMap.put(u, temp);
				}
				else
				{
					HashSet temp=new HashSet<Integer>();
					temp.add(v);
					hashMap.put(u,temp);
				}
				if(hashMap.containsKey(v))
				{
					HashSet temp=hashMap.get(v);
					temp.add(u);
					hashMap.put(v, temp);
				}
				else
				{
					HashSet temp=new HashSet<Integer>();
					temp.add(u);
					hashMap.put(v,temp);
				}	
			}
				
		}
		
		newKey=-1;
		for(Integer key: hashMap.keySet())
		{
			if(newKey!=-1)
				break;
			
			Queue<Integer> queue=new LinkedList<Integer>();
			int b[]=new int[n];
			Arrays.fill(b, -1);
			b[key-1]=0;
			if(key>0 && a[key-1]%k==0)
			{
				queue.add(key);
				
				while(!queue.isEmpty())
				{
					newKey=queue.poll();
					HashSet<Integer> temp=hashMap.get(newKey);
					if(temp!=null)
					{
						for(Integer val: temp)
						{
							if(a[val-1]%k==0 && b[val-1]==-1)
							{
								b[val-1]=b[newKey-1]+1;
								queue.add(val);
							}
						}
					}
				}
			}
		}
		
		//second BFS
		
		Integer key=newKey;
		Queue<Integer> queue=new LinkedList<Integer>();
		int b[]=new int[n];
		Arrays.fill(b, -1);
		if(key>0)
		b[key-1]=0;
		max=0;
		queue.add(key);
		while(!queue.isEmpty())
		{
			key=queue.poll();
			HashSet<Integer> temp=hashMap.get(key);
			if(temp!=null)
			{
				for(Integer val: temp)
				{
					if(a[val-1]%k==0 && b[val-1]==-1)
					{
						b[val-1]=b[key-1]+1;
						if(b[val-1]>max)
							max=b[val-1];
						queue.add(val);
					}
				}
			}
		}
		System.out.println(max);
		}
	}
