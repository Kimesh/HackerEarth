import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,a,b,count,n,q,m,ind;
		String ch;
		StringBuffer buff=new StringBuffer("");
		String temp1,temp2;
		
		Scanner sc=new Scanner(System.in);
		
		buff.append(sc.nextLine());
		q=sc.nextInt();
		
		for(i=0;i<q;i++)
		{
			ind=sc.nextInt();
			ch=sc.next();
			buff.replace(ind-1, ind, ch);
		}
		
		System.out.println(buff.toString());
		temp1=buff.toString();
		
		m=sc.nextInt();
		for(i=0;i<m;i++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			
			StringBuffer tempBuff=new StringBuffer(buff.substring(a-1, b));
			tempBuff.reverse();
			buff.replace(a-1, b, tempBuff.toString());
		}
		
		temp2=buff.toString();
		
		System.out.println(temp2);
		count=0;
		for(i=0;i<temp1.length();i++)
		{
			if(temp1.charAt(i)==temp2.charAt(i))
				count++;
		}
		System.out.println(count);
	}

}
