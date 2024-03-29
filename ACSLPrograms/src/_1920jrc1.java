import java.util.*;
public class _1920jrc1 {
/*
124987 2 3
540670 3 9
7145042 2 8
124987 2 523
4386709 1 2
4318762 4 3
72431685 1 7
123456789 7 8
9876543210 10 25
314159265358 8 428

 */
	static Scanner in;
	
	static String N;
	static int P, D;
	
	static String output;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i = 0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		N = in.next();
		P = in.nextInt();
		D = in.nextInt();
		
		output = "";
	}
	
	public static void solve() {
		int digit = pthDigit(N, P);
		if(0 <= digit && digit <= 4) {
			digit += D;
			digit %= 10;
		}
		else {
			digit = leftmost( Math.abs(digit - D) );
		}
		
		char[] o = new char[N.length()];
		int pIndex = N.length() - P;

		for(int i = 0;i<o.length;i++) {
			if(i < pIndex) {
				o[i] = N.charAt(i);
			}
			if(i > pIndex) {
				o[i] = '0';
			}
		}
		
		o[pIndex] = (char)(digit + '0');
		
		
		output = new String(o);
	}
	
	public static void output() {
		System.out.println(output);
	}
	
	public static int pthDigit(String N, int P) {
		char c = N.charAt(N.length() - P);
		return c - '0';
	}
	
	public static int leftmost(int num) {
		while(num > 9) {
			num /= 10;
		}
		return num;
	}
}
