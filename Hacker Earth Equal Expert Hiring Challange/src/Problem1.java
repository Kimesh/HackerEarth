import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1 {

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
                    st = new StringTokenizer(br.readLine());
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
		int i,j,k,n,q;
		long max=0,val;
		 FastReader sc=new FastReader();
		//Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		long a[]=new long[n];
		
		TreeSet<Long> ascTreeSet=new TreeSet<>();
		TreeSet<Long> descTreeSet=new TreeSet<>(Collections.reverseOrder());
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextLong();
			if(a[i]>max)
				max=a[i];
			if(!ascTreeSet.contains(a[i]))
				ascTreeSet.add(a[i]);
			else if(!descTreeSet.contains(a[i]))
				descTreeSet.add(a[i]);
		}
		
		q=sc.nextInt();
		for(i=0;i<q;i++)
		{
			val=sc.nextLong();
			if(val!=max)
			{
				if(val>max)
					max=val;
				if(!ascTreeSet.contains(val))
					ascTreeSet.add(val);
				else if(!descTreeSet.contains(val))
					descTreeSet.add(val);
			}
			System.out.println(ascTreeSet.size()+descTreeSet.size());
		}
		
		//Collections.sort(ascHashSe);
		for(Long value: ascTreeSet)
			System.out.print(value+" ");

		for(Long value: descTreeSet)
			System.out.print(value+" ");
	}
}
