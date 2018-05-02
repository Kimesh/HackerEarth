import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem2 {

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,t,n;
		Long k,localMin1,localMin2;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		while(t>0)
		{
			n=sc.nextInt();
			k=sc.nextLong();
			k=k%1000000007;
			localMin1=Long.MAX_VALUE;
			localMin2=Long.MAX_VALUE;
			long max=Long.MAX_VALUE;
			long a[]=new long[n];
			long b[]=new long[n-1];
			long c[]=new long[n-1];
			for(i=0;i<n;i++)
				a[i]=sc.nextLong();
				
			Arrays.sort(a);
			for(i=1;i<n;i++)
			{
				b[i-1]=(long) (Math.abs(Math.pow((a[i-1]-a[i]),k))%1000000007);
				c[i-1]=(long) (Math.abs(Math.pow((a[i]+a[i-1]),k))%1000000007);
				
				if((Math.abs(b[i-1]*c[i-1])%1000000007)<max)
						max=Math.abs(b[i-1]*c[i-1])%1000000007;
			}
			
			System.out.println(max);
			t--;
		}
		
	}

}
