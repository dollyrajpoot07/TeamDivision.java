// Team Division
// Consider an array inarr containing at least two non-zero positive integers ranging between 1 to 300 (inclusive of the boundary values). 
// Divide the integers in inarr into two groups based on the below rules:
// Each of the integers should belong to either of the two groups
// The total sum of integers in each of the groups must be as nearly equal as possible
// The total number of integers between the two groups should not differ by more than 1
// Print, outnum1 and outnum2, the sum of the integers of two groups separated by a space. If outnum1 and outnum2 are not equal, 
// then print the smaller sum followed by the larger sum.
// Sample Input
// 87,100,28,67,68,41,67,1
// Sample Output
// 229 230
// For the given input, the two groups that can be formed following the mentioned rules are:
// Group 1: 87 100 41 1
// Group 2: 28 67 68 67
// The total sum of integers in each of the groups which is as nearly equal as possible is:
// Group 1-Total Sum:229
// Group 2-Total Sum:230
// The total number of integers between group 1 and 2 differ by O integer.

import java.util.*;

class TeamDivision {
    
    public static int solve(int[] arr, int n, int S1, int S2, int lenS1, int lenS2) {
        if (n < 0) {
            if(Math.abs(lenS2 - lenS1) > 1) {
                return Integer.MAX_VALUE;
            }
            return Math.abs(S2 - S1);
        }
        return Math.min(solve(arr, n - 1, S1, S2, lenS1, lenS2),
                        solve(arr, n - 1, S1 + arr[n], S2 - arr[n], lenS1 + 1, lenS2 - 1));
    }
    
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
        
	    String string = scan.nextLine();
		String[] st = string.split(",");
		int n = st.length;
		int arr[] = new int[n];
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
		    arr[i] = Integer.parseInt(st[i]);
		    totalSum += arr[i];
		}
		int min = solve(arr, n - 1, 0, totalSum, 0, n);
		System.out.println((int)(totalSum/2f - min/2f) + " " + (int)(totalSum/2f + min/2f));
        scan.close();
	}
}