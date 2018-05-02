import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class SquareOrCube {
	
	static long segmentTree[];
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n, q, i, l, r;
		boolean squareFlag, cubeFlag;
		FastReader sc = new FastReader();
		n = sc.nextInt();
		q = sc.nextInt();
		long input[] = new long[n];
		for (i = 0; i < n; i++)
			input[i] = sc.nextLong();
		// long nextPowOf2 = (long)(Math.pow(2, Math.ceil(Math.log(n))));
		// if(nextPowOf2<n)
		// nextPowOf2=2*nextPowOf2;
		// long treeSize = 2 * nextPowOf2 - 1;
		int segmentTreeSize=getSegmentTreeSize(n);
		segmentTree = new long[segmentTreeSize];

		constructTree(input, segmentTree, 0, n - 1, 0);

		for (i = 0; i < q; i++) {
			squareFlag = false;
			cubeFlag = false;
			l = sc.nextInt();
			r = sc.nextInt();

			long product = gettingProduct(segmentTree, l - 1, r - 1, 0, n - 1, 0);
			//System.out.println(product);
			//product=new Long(-30000000000L);
			//BigDecimal bigDecimal=new BigDecimal(30000000000L);
			long square = (long) Math.sqrt(product);
			long cube = (long) Math.cbrt(product);

			if (square * square == product)
				squareFlag = true;
			if (cube * cube * cube == product)
				cubeFlag = true;

			if (squareFlag && !cubeFlag)
				System.out.println("Square");
			else if (!squareFlag && cubeFlag)
				System.out.println("Cube");
			else if (squareFlag && cubeFlag)
				System.out.println("Both");
			else
				System.out.println("None");
		}
	}

	private static void constructTree(long[] input, long[] segmentTree, int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}

		else {
			int mid = (low + high) / 2;
			constructTree(input, segmentTree, low, mid, 2 * pos + 1);
			constructTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
			segmentTree[pos] = segmentTree[2 * pos + 1] * segmentTree[2 * pos + 2];
		}

	}

	private static long gettingProduct(long[] segmentTree, int qlow, int qhigh, int low, int high, int pos) {

		if (qlow <= low && qhigh >= high)
			return segmentTree[pos];
		if (qlow > high || qhigh < low)
			return 1;
		int mid = (low + high) / 2;
		return gettingProduct(segmentTree, qlow, qhigh, low, mid, 2 * pos + 1)
				* gettingProduct(segmentTree, qlow, qhigh, mid + 1, high, 2 * pos + 2);
	}
	
	static int getSegmentTreeSize(int N) {
		  int size = 1;
		  for (; size < N; size <<= 1);
		  return size << 1;
		}
}
