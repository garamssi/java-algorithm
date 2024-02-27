package garam.week8.sunday_BinarySearch.문제1_GuessNumberHigherOrLower;

public class Solution {

	private static int num = 0;

	public static void main(String[] args) {
		num = 6;
		guessNumber(10);
	}

	public static int guessNumber(int n) {
		int low = 1;
		int high = n;

		while(low <= high){
			int mid = low+(high - low)/2;
			int pick = guess(mid);
			if(pick > 0) low = mid+1;
			else if(pick < 0) high = mid - 1;
			else return mid;
		}
		return -1;
	}

	public static int guess(int pick) {
		if (num > pick) return -1;
		else if (num < pick) return 1;
		else return 0; // num == pick
	}

}
