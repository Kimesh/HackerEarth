import java.util.InputMismatchException;
import java.util.Scanner;
class TestClass
{
	static void solve(int arr[]) throws Exception
	{
		int ans=0;
		
		for(int i=0;i<10;i++)
			for(int j=i+1;j<10;j++)
				ans+=arr[i]/arr[j];
		
		throw new MyException(ans);
	}
	public static void main(String args[])
	{
		try
		{
			Scanner in=new Scanner(System.in);
			int n=in.nextInt();
			int []arr= new int[n];
			in.nextLine();
			
			for(int i=0;i<10;i++)
				arr[i]=Integer.parseInt(in.nextLine());
			
			String s=in.nextLine();
			System.out.println(s.charAt(10));
			
			solve(arr);
		}
		catch (InputMismatchException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception encountered");
		}
		finally 
		{
			System.out.println("Exception Handling Completed");
		}
//Write your code here
	}
}
class MyException extends Exception {

	public MyException(int ans) {
		System.out.println("MyException["+Integer.toString(ans)+"]");
		
	}
}
//Write exception class here