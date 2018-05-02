import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,t,j,k;
		long count=1;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t>0)
		{
			count=1;
			HashSet<Character> hash=new HashSet<>();
			String s=sc.next();
			for(i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c=='a' || c=='e'|| c=='i'||c=='o' ||c=='u')
				{
					if(!hash.contains(c))
						hash.add(c);
				}
				else if(c=='_')
					count=count*hash.size();
			}
			System.out.println(count);
			
			t--;
		}
	}

}
