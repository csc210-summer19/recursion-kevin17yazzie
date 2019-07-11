/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Kevin Decker
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		return combinationsHelper(n, k);
	}

	private int combinationsHelper(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;

		return combinationsHelper(n - 1, k - 1) + combinationsHelper(n - 1, k);
	}

// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		System.out.println(n % 1000);
		System.out.println(n / 1000);

		if (n / 1000 == 0)
			return n + "";

		int remainder = n % 1000;
		String remainderString = "" + remainder;
		if (remainder < 100)
			remainderString = "0" + remainder;
		if (remainder < 10)
			remainderString = "00" + remainder;

		return intWithCommas(n / 1000) + "," + remainderString;

	}

// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index == len - 1 || len - 1 == 1)
			return;

		else {
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;

			reverseArray(x, index + 1, len - 1);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int min = a[0];
		int max = a[0];
		int start = 0;

		int range = arrayRangeHelper(a, start, min, max);
		return range;
	}

	private int arrayRangeHelper(int[] a, int start, int min, int max) {
		if (start == a.length)
			return max - min;
		if (a[start] < min)
			min = a[start];
		if (a[start] > max)
			max = a[start];

		return arrayRangeHelper(a, start + 1, min, max);

	}

// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		int start = 0;
		return isSortedHelper(nums, start);
	}

	private boolean isSortedHelper(int[] nums, int start) {

		if (start == nums.length - 1 || nums.length == 0)
			return true;
		return nums[start] <= nums[start + 1] && isSortedHelper(nums, start + 1);
	}

// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		int start = 0;
		return foundHelper(search, start, strs);
	}

	private boolean foundHelper(String search, int start, String[] strs) {
		if (start == strs.length)
			return false;
		if (strs[start].equals(search))
			return true;
		else
			return foundHelper(search, start + 1, strs);
	}
}
