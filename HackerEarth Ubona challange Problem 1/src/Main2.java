import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,k,m,n;
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		
		int a[]=new int[m];
		long b[][]=new long [m+1][n+1];
		
		for(i=0;i<m;i++)
			a[i]=sc.nextInt();
		
		for(i=0;i<m;i++)
			b[i][0]=1;
		
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(a[i-1]>j)
					b[i][j]=b[i-1][j];
				else 
					b[i][j]=(b[i-1][j]+b[i][j-a[i-1]])%1000000007;
			}
		}
		System.out.println(b[m][n]%1000000007);
	}

}
