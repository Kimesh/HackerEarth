import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t, i, j, k, n;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t > 0) {
			n = sc.nextInt();
			long a[] = new long[n];
			long area, maxarea = -1, lastIndex = -1;
			for (i = 0; i < n; i++)
				a[i] = sc.nextLong();
			int top;
			Stack<Integer> stack = new Stack<Integer>();
			for (i = 0; i < n; i++) {
				if (a[i] == 0) {
					maxarea=calcualteArea(lastIndex, i, a, stack, maxarea);
					lastIndex=i;
				} else if (stack.isEmpty() || a[i] >= a[stack.peek()])
					stack.push(i);
				else {
					while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
						top = stack.pop();
						if (stack.isEmpty())
						{
							if(lastIndex==-1)
								area=a[top]*i;
							else
								area = a[top] * (i-lastIndex-1);	
						}
							
						else
							area = a[top] * (i - stack.peek() - 1);
						if (area > maxarea)
							maxarea = area;
					}
					stack.push(i);
				}

			}
			while (!stack.isEmpty()) {
				top = stack.pop();
				if (stack.isEmpty())
				{
					if(lastIndex==-1)
						area=a[top]*i;
					else
						area = a[top] * (i-lastIndex-1);
				}
				else
					area = a[top] * (i - stack.peek() - 1);
				if (area > maxarea)
					maxarea = area;
			}
			System.out.println(maxarea);
			t--;
		}
	}

	private static long calcualteArea(long lastIndex, int i, long[] a, Stack<Integer> stack, long maxarea) {
		// TODO Auto-generated method stub
		int top;
		long area;
		if (stack.isEmpty() || a[i] >= a[stack.peek()])
			stack.push(i);
		else {
			while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
				top = stack.pop();
				if (stack.isEmpty())
					area = a[top] * i;
				else
					area = a[top] * (i - stack.peek() - 1);
				if (area > maxarea)
					maxarea = area;
			}
			stack.push(i);
		}

		while (!stack.isEmpty())

		{
			top = stack.pop();
			if (stack.isEmpty())
				area = a[top] * i;
			else
				area = a[top] * (i - stack.peek() - 1);
			if (area > maxarea)
				maxarea = area;
		}
		return maxarea;
	}
}
