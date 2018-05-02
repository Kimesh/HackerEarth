import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int i, j, q;
		long n;
		List<String> l = new ArrayList<String>();
		String s = sc.nextLine();
		n = s.length();

		for (i = 0; i < n; i++) {
			for (j = i + 1; j <= n; j++)
				l.add(s.substring(i, j));
		}
		n = l.size();
		q = sc.nextInt();
		while (q > 0) {
			String temp = sc.next();
			long index = Long.parseLong(temp);
			if (index > n)
				System.out.println(-1);
			else
				System.out.println(l.get((int) index - 1).toString());
			q--;
		}
		
	}

}
