import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemoveTheElement {

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
	public static void main(String[] args)
	{
		int i,n,j,t;
		long value,fact;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		while(t>0)
		{
			n=sc.nextInt();
			long a[]=new long [n];
			for(i=0;i<n;i++)
				a[i]=sc.nextLong();
			value=0;
			fact=1;
			Arrays.sort(a);
			
			for(i=n-1;i>=0;i--)
			{
				fact=(fact*(n-i))%1000000007;
				if(fact==0)
					fact=1;
				value=(value+fact*a[i])%1000000007;
			}
			System.out.println(value);
			t--;
		}
	}
}
