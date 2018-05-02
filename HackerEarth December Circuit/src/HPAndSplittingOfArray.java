import java.util.Arrays;
import java.util.Scanner;

public class HPAndSplittingOfArray {

	static long count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i, t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t > 0) {
			count = 0;
			n = sc.nextInt();
			long a[] = new long[n];
			for (i = 0; i < n; i++)
				a[i] = sc.nextLong();

			long b[] = MergeSort(a, 0, n - 1);

			for (i = 0; i < a.length; i++) {
				int index = Arrays.binarySearch(b, 0, b.length, a[i]);
				// System.out.println("index: "+index);
				System.out.print(count + (n - index - 1) - index + " ");
				count = count + (n - index - 1) - index;
			}
			// System.out.println(b[i]);
			System.out.println();
			t--;
		}
	}

	private static long[] MergeSort(long[] a, int l, int u) {

		if (l == u) {
			long temp[] = new long[1];
			temp[0] = a[l];
			return temp;
		}
		else if(l>u)
			return null;
		else {
			int mid = (l + u) / 2;
			long b[] = MergeSort(a, l, mid);
			long c[] = MergeSort(a, mid + 1, u);
			if(b==null && c==null)
				return null;
			else if(b==null && c!=null)
				return c;
			else if(b!=null && c==null)
				return b;
			return Merge(b, c, b.length, c.length);
		}
	}

	private static long[] Merge(long[] b, long[] c, int l1, int l2) {

		int i, j, k;
		i = 0;
		j = 0;
		long temp[] = new long[l1 + l2];
		for (k = 0; k < l1 + l2 && i < l1 && j < l2; k++) {
			if (b[i] > c[j]) {
				count++;
				temp[k] = c[j];
				j++;
			} else {
				temp[k] = b[i];
				i++;
			}
		}
		while (i < l1) {
			temp[k] = b[i];
			i++;
			k++;
		}
		while (j < l2) {
			temp[k] = c[j];
			j++;
			k++;
		}

		return temp;
	}

}
