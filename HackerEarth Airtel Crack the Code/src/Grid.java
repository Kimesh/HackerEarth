import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Grid {

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

		int i,j,n,m,q,source_i,source_j,destination_i,destination_j;
		String s;
		Queue<Point> queue=new LinkedList<Point>();
		FastReader sc=new FastReader();
		n=sc.nextInt();
		m=sc.nextInt();
		q=sc.nextInt();
		char grid[][]=new char[n][m];
		int minStepGrid[][]=new int[n][m];
		for(i=0;i<n;i++)
		{
			s=sc.next();
			for(j=0;j<s.length();j++)
			{
				grid[i][j]=s.charAt(j);
				minStepGrid[i][j]=Integer.MAX_VALUE;
			}
		}
		source_i=sc.nextInt();
		source_j=sc.nextInt();
		minStepGrid[source_i-1][source_j-1]=0;
		Point point=new Point(source_i-1,source_j-1);
		queue.add(point);
		Point temp;
		while(!queue.isEmpty())
		{
			Point p=queue.poll();
			if(p.x-1>=0 && grid[p.x-1][p.y]=='O'&& minStepGrid[p.x-1][p.y]>minStepGrid[p.x][p.y]+1)
			{
				minStepGrid[p.x-1][p.y]=minStepGrid[p.x][p.y]+1;
				temp=new Point(p.x-1, p.y);
				queue.add(temp);
			}
				
			if(p.x+1<n && grid[p.x+1][p.y]=='O'&& minStepGrid[p.x+1][p.y]>minStepGrid[p.x][p.y]+1)
			{
				minStepGrid[p.x+1][p.y]=minStepGrid[p.x][p.y]+1;
				temp=new Point(p.x+1, p.y);
				queue.add(temp);
			}
				
			if(p.y-1>=0 && grid[p.x][p.y-1]=='O' && minStepGrid[p.x][p.y-1]>minStepGrid[p.x][p.y]+1)
			{
				minStepGrid[p.x][p.y-1]=minStepGrid[p.x][p.y]+1;
				temp=new Point(p.x, p.y-1);
				queue.add(temp);
			}
				
			if (p.y+1<m && grid[p.x][p.y+1]=='O' && minStepGrid[p.x][p.y+1]>minStepGrid[p.x][p.y]+1)
			{
				minStepGrid[p.x][p.y+1]=minStepGrid[p.x][p.y]+1;
				temp=new Point(p.x, p.y+1);
				queue.add(temp);
			}
		}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(minStepGrid[i][j]==Integer.MAX_VALUE)
					minStepGrid[i][j]=-1;
			}
		}
		
		for(i=0;i<q;i++)
		{
			destination_i=sc.nextInt();
			destination_j=sc.nextInt();
			System.out.println(minStepGrid[destination_i-1][destination_j-1]);
		}
		//sc.close();
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}